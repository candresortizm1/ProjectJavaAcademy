package com.globant.academy.project.Project.controllers;

import com.globant.academy.project.Project.dtos.MessageDTO;
import com.globant.academy.project.Project.entities.AppMessage;
import com.globant.academy.project.Project.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/{userId}/messages")
public class MessagesController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<String> sendMessage(@PathVariable String userId, @RequestBody AppMessage message){
        messageService.sendMessage(userId, message);
        return new ResponseEntity<>("message Sent", HttpStatus.CREATED);
    }

    @PostMapping("/{messageId}/labels")
    public ResponseEntity<String> labelMessage(@PathVariable String messageId, @RequestBody AppMessage message){
        messageService.addLabel(message,messageId);
        return new ResponseEntity<>("labelAdded", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MessageDTO>> getMessages(@PathVariable String userId, @RequestParam String folder){
        List<MessageDTO> responseMessages = messageService.getMessages(userId, folder);
        return new ResponseEntity<>(responseMessages, HttpStatus.OK);
    }

}
