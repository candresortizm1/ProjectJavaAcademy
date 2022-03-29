package com.globant.academy.project.Project.dtos;

import com.globant.academy.project.Project.entities.AppMessage;
import com.globant.academy.project.Project.entities.ReceiverMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiverMessageMapper {

    @Autowired
    private static UserMapper usermapper;

    public static ReceiverMessageDTO modelToDTO(ReceiverMessage receiverMessage){
        UserDTO userDTO = usermapper.modelToDTO(receiverMessage.getReceiver());
        ReceiverMessageDTO receiverMessageDTO = ReceiverMessageDTO.builder()
                .user(userDTO)
                .type(receiverMessage.getReceiverType().getId())
                .build();
        return receiverMessageDTO;
    }

    public static List<ReceiverMessageDTO> listModelToDTO(List<ReceiverMessage> receiverMessage){
        List<ReceiverMessageDTO> receiverMessageDTOs = (List<ReceiverMessageDTO>) receiverMessage.stream().map(element -> {
            return modelToDTO(element);
        }).toList();
        return receiverMessageDTOs;
    }

}
