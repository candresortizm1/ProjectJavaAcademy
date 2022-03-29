package com.globant.academy.project.Project.services;

import com.globant.academy.project.Project.dtos.*;
import com.globant.academy.project.Project.entities.*;
import com.globant.academy.project.Project.repositories.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService{

    private final AppMessageRepository messageRepository;
    private final AppUserRepository appUserRepository;
    private final MessageMapper messageMapper;
    private final LabelRepository labelRepository;

    @Override
    public void sendMessage(String userId_str, AppMessage appMessage) {
        int userId = Integer.parseInt(userId_str);
        appMessage.setSender(appUserRepository.getById(userId));
        log.info("Saving message");
        messageRepository.save(appMessage);
    }

    @Override
    public List<MessageDTO> getMessages(String id, String messagesType) {
        int userId = Integer.parseInt(id);
        List<AppMessage> allMessages = new ArrayList<>();
        if(messagesType!=null){
            if(messagesType.equals("sent")){
                allMessages = appUserRepository.getById(userId).getSentMessages();
            }else if(messagesType.equals("inbox")){
                allMessages = appUserRepository.getById(userId).getReceivedMessages();
            }
        }
        List<MessageDTO> allMessagesDTO = messageMapper.listModelToDTO(allMessages);
        return allMessagesDTO;
    }

    @Override
    public String addLabel(AppMessage appMessage, String messageIdStr) {
        int messageId = Integer.parseInt(messageIdStr);
        AppMessage finalMessage = messageRepository.findById(messageId).get();

        List<Label> labels = (List<Label>) appMessage.getLabels().stream().map(element->{
            return labelRepository.findById(element.getId()).get();}).toList();
        finalMessage.setLabels(labels);
        messageRepository.save(finalMessage);
        return "labels added";
    }

}
