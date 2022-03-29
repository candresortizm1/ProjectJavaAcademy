package com.globant.academy.project.Project.services;

import com.globant.academy.project.Project.dtos.MessageDTO;
import com.globant.academy.project.Project.entities.Label;

import java.util.List;

public interface LabelService {
    void createLabel(String userId, Label label);
    List<MessageDTO> getMessagesWithLabel(String userId, int labelId);
}
