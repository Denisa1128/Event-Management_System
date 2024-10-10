package com.itschool.eventmanagment.services;

import com.itschool.eventmanagment.models.dtos.EventDTO;
import com.itschool.eventmanagment.models.dtos.ParticipantDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface EventService {
    EventDTO createEvent(EventDTO eventDTO);

    void deleteEvent(Long id);

   EventDTO updateEvent(EventDTO eventDTO);

    List<EventDTO> getEvents();

    List<ParticipantDTO> getRegisteredParticipants(Long eventId);
  
    List<EventDTO> getEvents(LocalDateTime to, LocalDateTime from, String location, String sortBy);
}