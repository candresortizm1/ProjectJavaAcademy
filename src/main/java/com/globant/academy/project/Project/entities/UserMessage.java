package com.globant.academy.project.Project.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.List;
import static javax.persistence.GenerationType.IDENTITY;

@Entity(name="user_message")
@Data
public class UserMessage {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="sender_id")
    private AppUser sender;

    @ManyToOne
    @JoinColumn(name="receiver_id")
    private AppUser receiver;

    @ManyToOne
    @JoinColumn(name="message_id")
    private AppMessage message;

    @ManyToOne
    @JoinColumn(name="type_receiver_id")
    private ReceiverType receiverType;

    @ManyToMany(mappedBy = "userMessages")
    private List<Label> labels;

}
