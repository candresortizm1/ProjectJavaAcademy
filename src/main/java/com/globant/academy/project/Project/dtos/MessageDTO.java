package com.globant.academy.project.Project.dtos;

import com.globant.academy.project.Project.entities.AppMessage;
import com.globant.academy.project.Project.entities.MessageAttachment;
import com.globant.academy.project.Project.entities.UserMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class MessageDTO {
    private AppMessage message;
    private List<UserMessage> receivers;
    private List<MessageAttachment> attachments;
}
