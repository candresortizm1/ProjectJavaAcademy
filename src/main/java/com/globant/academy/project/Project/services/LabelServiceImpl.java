package com.globant.academy.project.Project.services;

import com.globant.academy.project.Project.dtos.MessageDTO;
import com.globant.academy.project.Project.entities.Label;
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

    @Autowired
    private LabelRepository labelRepository;

    @Override
    public void createLabel(String userId, Label label) {
        labelRepository.save(label);
    }

    @Override
    public List<MessageDTO> getMessagesWithLabel(String userId, int labelId) {
        return null;
    }
}
