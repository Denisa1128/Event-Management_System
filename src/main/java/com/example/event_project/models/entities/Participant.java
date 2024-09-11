package com.example.event_project.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Participant {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column
        private String name;

        @ManyToMany
        @JoinTable(
                name = "events_participants",
                joinColumns = @JoinColumn(name = "participant_id"),
                inverseJoinColumns = @JoinColumn(name = "event_id")
        )
        private Set<Event> events = new HashSet<>();
}