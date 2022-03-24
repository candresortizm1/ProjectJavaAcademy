package com.globant.academy.project.Project.services;

import com.globant.academy.project.Project.dtos.MessageDTO;
import com.globant.academy.project.Project.entities.AppMessage;
import com.globant.academy.project.Project.entities.UserMessage;

import java.util.List;

public interface MessageService {
    void sendMessage(MessageDTO messageDTO);
    List<AppMessage> getSentMessages(UserMessage user);
    List<AppMessage> getInboxMessages(UserMessage user);
    AppMessage getMessage(int message_id);
}
