package com.globant.academy.project.Project.dtos;

import com.globant.academy.project.Project.entities.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class MessageDTO {
    private int id;
    private int senderId;
    private String senderNickname;
    private String subject;
    private String body;
    private List<ReceiverMessageDTO> receivers;

}
