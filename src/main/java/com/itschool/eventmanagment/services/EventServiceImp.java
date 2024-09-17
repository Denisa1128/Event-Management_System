package com.itschool.eventmanagment.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.eventmanagment.models.dtos.ParticipantDetailsDTO;
import com.itschool.eventmanagment.models.dtos.EventDTO;
import com.itschool.eventmanagment.models.entities.Event;
import com.itschool.eventmanagment.models.entities.Participant;
import com.itschool.eventmanagment.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EventServiceImp implements EventService {
    private EventRepository eventRepository;

    public EventServiceImp(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public EventDTO createEvent(EventDTO eventDTO) {
        return null;
    }

    @Override
    public List<EventDTO> deleteEvent() {
        return null;
    }

    @Override
    public List<EventDTO> updateEvent() {
        return null;
    }

    @Override
    public List<EventDTO> getEvents() {
        return null;
    }

    @Override
    public List<ParticipantDetailsDTO> getRegisteredParticipants(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Event not found id: " + eventId));

        return mapParticipantsToDTOs(event.getParticipants());
    }

    public List<ParticipantDetailsDTO> mapParticipantsToDTOs(List<Participant> participants) {
        return participants.stream()
                .map(participant -> new ParticipantDetailsDTO(
                        participant.getFirstName(),
                        participant.getLastName(),
                        participant.getEmail()
                ))
                .collect(Collectors.toList());
    }
}