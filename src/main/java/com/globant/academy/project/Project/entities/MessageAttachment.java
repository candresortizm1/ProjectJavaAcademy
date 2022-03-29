package com.globant.academy.project.Project.entities;

import lombok.Data;
import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity(name="message_attachment")
@Data
public class MessageAttachment {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="message_id")
    private AppMessage message;


}
