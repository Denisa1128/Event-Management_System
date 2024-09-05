package com.example.event_project;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager();

        eventManager.addEvent("Programming Workshop", LocalDateTime.of(2024, 9, 10, 14, 0), "Sala 301, Universitatea X", 30);
        eventManager.addEvent("Technological Seminar", LocalDateTime.of(2024, 10, 12, 10, 0), "Sala A, Universitatea Y", 50);

        System.out.println("All Events:");
        eventManager.viewEvents();

        eventManager.modifyEvent("Programming Workshop", LocalDateTime.of(2024, 9, 12, 14, 0), "Sala 302, Universitatea X", 35);

        Event event = eventManager.findEventByName("Programming Workshop");
        if (event != null) {
            Participant participant = new Participant("John Doe", "john.doe@example.com", "1234567890");
            if (event.registerParticipant(participant)) {
                System.out.println("Participant registered.");
            } else {
                System.out.println("Event is full.");
            }
        }

        System.out.println("Updated Event:");
        eventManager.viewEvents();
    }
}