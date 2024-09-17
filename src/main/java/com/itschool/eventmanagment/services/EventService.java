package com.itschool.eventmanagment.services;

import com.itschool.eventmanagment.models.dtos.DetailsParticipantDTO;
import com.itschool.eventmanagment.models.dtos.EventDTO;

import java.util.List;


public interface EventService {
    EventDTO createEvent(EventDTO eventDTO);

    List<EventDTO> deleteEvent();

    List<EventDTO> updateEvent();

    List<EventDTO> getEvents();

    List<DetailsParticipantDTO> getRegisteredParticipants(Long eventId);
}