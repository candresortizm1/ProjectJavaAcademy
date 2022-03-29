package com.globant.academy.project.Project.services;

import com.globant.academy.project.Project.dtos.MessageDTO;
import com.globant.academy.project.Project.entities.AppMessage;
import com.globant.academy.project.Project.entities.ReceiverMessage;

import java.util.List;

public interface MessageService {
    void sendMessage(String userId, AppMessage appMessage);
    List<MessageDTO> getMessages(String user_id, String messagesType);
}
