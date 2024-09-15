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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column
    private String name;
    @Column
    private LocalDateTime dateTime;
    @Column
    private String location;
    @Column
    private int maxParticipants;
    @ManyToMany
    @JoinTable(
            name = "events_participants",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_id")
    )
    private List<Participant> participants = new ArrayList<>();

    @ManyToOne
    private User user;

    public boolean registerParticipant(Participant participant) {
        if (participants.size() < maxParticipants) {
            participants.add(participant);
            return true;
        } else {
            return false;
        }
    }
}