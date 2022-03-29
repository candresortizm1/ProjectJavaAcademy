package com.globant.academy.project.Project.dtos;

import com.globant.academy.project.Project.entities.AppMessage;
import com.globant.academy.project.Project.entities.AppUser;
import com.globant.academy.project.Project.entities.ReceiverMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageMapper {

    @Autowired
    static private ReceiverMessageMapper receiverMessageMapper;

    public static MessageDTO modelToDTO(AppMessage message){
        List<ReceiverMessageDTO> receiverMessagesDTO = receiverMessageMapper.listModelToDTO(message.getReceiverMessages());
        AppUser sender = message.getSender();
        MessageDTO messageDTO = MessageDTO.builder()
                .id(message.getId())
                .body(message.getBody())
                .subject(message.getSubject())
                .receivers(receiverMessagesDTO)
                .senderId(sender.getId())
                .senderNickname(sender.getNickname())
                .build();
        return messageDTO;
    }

    public static List<MessageDTO> listModelToDTO(List<AppMessage> messages){
        List<MessageDTO> messagesDTOs = (List<MessageDTO>) messages.stream().map(element -> {
            return modelToDTO(element);
        }).toList();
        return messagesDTOs;
    }

}
