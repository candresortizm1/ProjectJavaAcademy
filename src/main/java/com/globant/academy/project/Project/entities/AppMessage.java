package com.globant.academy.project.Project.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import static javax.persistence.GenerationType.IDENTITY;

@Entity(name="message")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppMessage{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    @OneToMany(targetEntity = ReceiverMessage.class, cascade = CascadeType.ALL)
    @JoinColumn(name ="message_id",referencedColumnName = "id")
    private List<ReceiverMessage> receiverMessages;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sender_id", nullable = false)
    private AppUser sender;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "body", columnDefinition = "TEXT")
    private String body;

    @OneToMany(mappedBy = "message")
    private List<MessageAttachment> messageAttachments;

    @ManyToMany(mappedBy = "messages")
    private List<Label> labels;

}
