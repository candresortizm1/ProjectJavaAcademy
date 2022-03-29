package com.globant.academy.project.Project.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity(name="user_message")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReceiverMessage {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="receiver_id", nullable = false)
    private AppUser receiver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="message_id",referencedColumnName = "id")
    private AppMessage message;

    @ManyToOne
    @JoinColumn(name="type_receiver_id", nullable = false)
    private ReceiverType receiverType;

}
