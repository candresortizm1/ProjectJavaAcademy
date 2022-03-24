package com.globant.academy.project.Project.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.List;
import static javax.persistence.GenerationType.IDENTITY;

@Entity(name="message")
@Data
public class AppMessage {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @OneToMany(mappedBy = "message")
    private List<UserMessage> userMessages;

    /*@ManyToMany(mappedBy = "books")
    private List<Author> authors;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;*/

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "name", columnDefinition = "TEXT")
    private String body;

    @OneToMany(mappedBy = "message")
    private List<MessageAttachment> messageAttachments;

}
