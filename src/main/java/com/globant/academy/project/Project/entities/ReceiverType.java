package com.globant.academy.project.Project.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.List;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class ReceiverType {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private byte id;

    private String receiverType;

    @OneToMany(mappedBy = "receiverType")
    private List<UserMessage> userMessages;
}
