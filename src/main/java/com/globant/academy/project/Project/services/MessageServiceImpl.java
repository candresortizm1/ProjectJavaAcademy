package com.globant.academy.project.Project.services;

import com.globant.academy.project.Project.dtos.MessageDTO;
import com.globant.academy.project.Project.entities.AppMessage;
import com.globant.academy.project.Project.entities.MessageAttachment;
import com.globant.academy.project.Project.entities.UserMessage;
import com.globant.academy.project.Project.repositories.AppMessageRepository;
import com.globant.academy.project.Project.repositories.MessageAttachmentRepository;
import com.globant.academy.project.Project.repositories.UserMessageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService{

    private final AppMessageRepository messageRepository;
    private final MessageAttachmentRepository messageAttachmentRepository;
    private final UserMessageRepository userMessageRepository;

    @Override
    public void sendMessage(MessageDTO messageDTO) {
        log.info("Saving message");
        AppMessage message = messageRepository.save(messageDTO.getMessage());
        log.info("Saving attachments");
        List<MessageAttachment> attachments = messageAttachmentRepository.saveAll(messageDTO.getAttachments());
        log.info("Saving receivers");
        List<UserMessage> userMessages = userMessageRepository.saveAll(messageDTO.getReceivers());
    }

    @Override
    public List<AppMessage> getSentMessages(UserMessage user) {
        return null;
    }

    @Override
    public List<AppMessage> getInboxMessages(UserMessage user) {
        return null;
    }

    @Override
    public AppMessage getMessage(int message_id) {
        return null;
    }
}
