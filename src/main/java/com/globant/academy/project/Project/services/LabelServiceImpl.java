package com.globant.academy.project.Project.services;

import com.globant.academy.project.Project.dtos.LabelDTO;
import com.globant.academy.project.Project.dtos.LabelMapper;
import com.globant.academy.project.Project.dtos.MessageDTO;
import com.globant.academy.project.Project.dtos.MessageMapper;
import com.globant.academy.project.Project.entities.AppUser;
import com.globant.academy.project.Project.entities.Label;
import com.globant.academy.project.Project.repositories.AppUserRepository;
import com.globant.academy.project.Project.repositories.LabelRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class LabelServiceImpl implements LabelService{

    private LabelRepository labelRepository;
    private MessageMapper messageMapper;
    private AppUserRepository appUserRepository;
    private LabelMapper labelMapper;

    @Override
    public void createLabel(String userIdStr, Label label) {
        int userId = Integer.parseInt(userIdStr);
        AppUser user = appUserRepository.getById(userId);
        label.setUser(user);
        labelRepository.save(label);
    }

    @Override
    public List<MessageDTO> getMessagesWithLabel(String userIdStr, String labelIdStr) {
        int labelId = Integer.parseInt(labelIdStr);
        int userId = Integer.parseInt(userIdStr);
        Label label = labelRepository.findById(labelId).get();
        List<MessageDTO> messages = messageMapper.listModelToDTO(label.getMessages());
        return messages;
    }

    @Override
    public List<LabelDTO> getLabels(String userIdStr) {
        int userId = Integer.parseInt(userIdStr);
        List<Label> labels = labelRepository.findAllByUserId(userId);
        List<LabelDTO> labelsDTO = labelMapper.listModelToDTO(labels);
        return labelsDTO;
    }
}
