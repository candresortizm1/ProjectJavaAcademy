package com.globant.academy.project.Project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name="user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUser{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    @Column(name="nickname")
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
            mappedBy = "sender",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )

    private List<AppMessage> sentMessages = new ArrayList<>();

    @OneToMany(
            mappedBy = "receiver",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<ReceiverMessage> receivedUserMessages = new ArrayList<>();

    @OneToMany(
            mappedBy = "user",
            orphanRemoval = true,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Label> labels = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "user_message",
            joinColumns = @JoinColumn(name = "receiver_id"),
            inverseJoinColumns = @JoinColumn(name = "message_id"))
    private List<AppMessage> receivedMessages = new ArrayList<>();

}
