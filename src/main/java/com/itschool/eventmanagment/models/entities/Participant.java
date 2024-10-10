package com.itschool.eventmanagment.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "events_participants",
            joinColumns = @JoinColumn(name = "participant_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private Set<Event> events = new HashSet<>();

    public Participant(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName= firstName;
        this.lastName = lastName;
        this.email = email;
    }
}