package com.example.event_project;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private final List<Event> events;

    public EventManager() {
        events = new ArrayList<>();
    }

    public void addEvent(String name, LocalDateTime dateTime, String location, int maxParticipants) {
        Event event = new Event(name, dateTime, location, maxParticipants);
        events.add(event);
        System.out.println("Event added: " + name);
    }

    public void viewEvents() {
        for (Event event : events) {
            System.out.println(event.toString());
        }
    }

    public Event findEventByName(String name) {
        for (Event event : events) {
            if (event.getName().equalsIgnoreCase(name)) {
                return event;
            }
        }
        return null;
    }

    public void modifyEvent(String name, LocalDateTime newDateTime, String newLocation, int newMaxParticipants) {
        Event event = findEventByName(name);
        if (event != null) {
            event.setDateTime(newDateTime);
            event.setLocation(newLocation);
            event.setMaxParticipants(newMaxParticipants);
            System.out.println("Event modified: " + name);
        } else {
            System.out.println("Event not found.");
        }
    }

    public void deleteEvent(String name) {
        Event event = findEventByName(name);
        if (event != null) {
            events.remove(event);
            System.out.println("Event deleted: " + name);
        } else {
            System.out.println("Event not found.");
        }
    }
}