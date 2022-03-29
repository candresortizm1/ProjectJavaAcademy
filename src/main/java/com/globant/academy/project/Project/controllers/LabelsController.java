package com.globant.academy.project.Project.controllers;

import com.globant.academy.project.Project.dtos.LabelDTO;
import com.globant.academy.project.Project.dtos.MessageDTO;
import com.globant.academy.project.Project.entities.Label;
import com.globant.academy.project.Project.services.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/{userId}/labels")
public class LabelsController {
    @Autowired
    private LabelService labelService;

    @PostMapping
    public ResponseEntity<String> createLabel(@PathVariable String userId, @RequestBody Label label){
        labelService.createLabel(userId, label);
        return new ResponseEntity<>("Label created", HttpStatus.CREATED);
    }

    @GetMapping("/{labelId}/messages")
    public ResponseEntity<List<MessageDTO>> getMessagesWithLabel(@PathVariable String userId, @PathVariable String labelId){
        List<MessageDTO> messages = labelService.getMessagesWithLabel(userId,labelId);
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LabelDTO>> getLabels(@PathVariable String userId){
        return new ResponseEntity<>(labelService.getLabels(userId), HttpStatus.OK);
    }

}
