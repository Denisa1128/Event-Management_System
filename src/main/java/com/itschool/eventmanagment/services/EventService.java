package com.itschool.eventmanagment.services;

import com.itschool.eventmanagment.models.dtos.ParticipantDetailsDTO;
import com.itschool.eventmanagment.models.dtos.EventDTO;

import java.util.List;


public interface EventService {
    EventDTO createEvent(EventDTO eventDTO);

    List<EventDTO> deleteEvent();

    List<EventDTO> updateEvent();

    List<EventDTO> getEvents();

    List<ParticipantDetailsDTO> getRegisteredParticipants(Long eventId);
}