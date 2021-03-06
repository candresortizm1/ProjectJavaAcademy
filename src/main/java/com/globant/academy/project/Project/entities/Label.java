package com.globant.academy.project.Project.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name="label")
@Data
public class Label {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private AppUser user;

    private String label;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "label_message",
            joinColumns = @JoinColumn(name = "message_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "label_id", referencedColumnName = "id"))
    private List<AppMessage> messages;
}
