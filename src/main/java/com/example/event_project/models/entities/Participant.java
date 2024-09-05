package com.example.event_project.models.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
@Entity
@Table(name = "participants")
public class Participant {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column
        private String firstName;
        @Column
        private String lastName;
        @Column
        private String email;
        @ManyToMany(mappedBy = "participants", cascade = CascadeType.ALL)
        @JoinTable(
                name = "events_participants",
                joinColumns = @JoinColumn(name = "participant_id"),
                inverseJoinColumns = @JoinColumn(name = "event_id")
        )
        private Set<Event> events = new ArrayList();
    }