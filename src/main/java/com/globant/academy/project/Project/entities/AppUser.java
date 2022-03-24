package com.globant.academy.project.Project.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name="user")
@Data
public class AppUser {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    @Column(name="nickname", unique=true)
    private String nickname;

    @Column(name="name")
    private String name;

    @Column(name="last_name")
    private String lastName;

    @Column(name="document")
    private long document;

    @Column(name="address")
    private String address;

    //@Getter(AccessLevel.NONE)
    @Column(name="zip_code")
    private int zipCode;

    @Column(name="state")
    private String state;

    @Column(name="country")
    private String country;

    @OneToMany(
            mappedBy = "user",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Label> labels = new ArrayList<>();

    @OneToMany(
            mappedBy = "sender",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<UserMessage> sentUserMessages = new ArrayList<>();

    @OneToMany(
            mappedBy = "receiver",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<UserMessage> receivedUserMessages = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "user_message",
            joinColumns = @JoinColumn(name = "receiver_id"),
            inverseJoinColumns = @JoinColumn(name = "message_id"))
    private List<AppMessage> receivedMessages = new ArrayList<>();

    @OneToMany
    @JoinTable(name = "user_message",
            joinColumns = @JoinColumn(name = "sender_id"),
            inverseJoinColumns = @JoinColumn(name = "message_id"))
    private List<AppMessage> sentMessages = new ArrayList<>();


}
