package com.globant.academy.project.Project.controllers;

import com.globant.academy.project.Project.dtos.MessageDTO;
import com.globant.academy.project.Project.dtos.MessageMapper;
import com.globant.academy.project.Project.entities.AppMessage;
import com.globant.academy.project.Project.entities.AppUser;
import com.globant.academy.project.Project.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/{userId}/messages")
public class MessagesController {
    @Autowired
    private MessageService messageService;

    @PostMapping
    public String sendMessage(@PathVariable String userId, @RequestBody AppMessage message){
        messageService.sendMessage(userId, message);
        return "message Sent";
    }

    /*@PostMapping("/{user_id}/labels")
    public String labelMessage(@RequestBody AppMessage message){
        messageService.addLabel(message);
        return "Label created";
    }
*/
    @GetMapping
    public List<MessageDTO> getMessages(@PathVariable String userId, @RequestParam String folder){
        List<MessageDTO> responseMessages = messageService.getMessages(userId, folder);
        return responseMessages;
    }


}
