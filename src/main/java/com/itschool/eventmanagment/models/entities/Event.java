package com.itschool.eventmanagment.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
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
    private List<Participant> registeredParticipants = new ArrayList<>();

    public boolean registerParticipant(Participant participant) {
        if (registeredParticipants.size() < maxParticipants) {
            registeredParticipants.add(participant);
            return true;
        } else {
            return false;
        }
    }
}