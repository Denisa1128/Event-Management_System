package com.example.event_project;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Event {
    @Setter
    private String name;
    @Setter
    private LocalDateTime dateTime;
    @Setter
    private String location;
    @Setter
    private int maxParticipants;
    private final List<Participant> registeredParticipants;

    public Event(String name, LocalDateTime dateTime, String location, int maxParticipants) {
        this.name = name;
        this.dateTime = dateTime;
        this.location = location;
        this.maxParticipants = maxParticipants;
        this.registeredParticipants = new ArrayList<>();
    }

    public boolean registerParticipant(Participant participant) {
        if (registeredParticipants.size() < maxParticipants) {
            registeredParticipants.add(participant);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Event Name: " + name +
                "\nDate and Time: " + dateTime +
                "\nLocation: " + location +
                "\nRegistered Participants: " + registeredParticipants.size() + "/" + maxParticipants;
    }
}