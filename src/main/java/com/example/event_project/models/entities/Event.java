package com.example.event_project.models.entities;

import com.example.event_project.Participant;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column
    private String name;
    @Column
    private LocalDateTime dateTime;
    @Column
    private String location;
    @Column
    private int maxParticipants;
    @ManyToMany(mappedBy = "events", cascade = CascadeType.ALL)
    private final List<Event> registeredParticipants = new ArrayList<>();

    public boolean registerParticipant(Participant participant) {
        if (registeredParticipants.size() < maxParticipants) {
            registeredParticipants.add(Event);
            return true;
        } else {
            return false;
        }
    }
}