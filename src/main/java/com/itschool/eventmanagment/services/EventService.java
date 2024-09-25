package com.itschool.eventmanagment.services;

import com.itschool.eventmanagment.models.dtos.ParticipantDetailsDTO;
import com.itschool.eventmanagment.models.dtos.EventDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface EventService {
    EventDTO createEvent(EventDTO eventDTO);

    List<EventDTO> deleteEvent();

    List<EventDTO> updateEvent(EventDTO eventDTO);

    List<EventDTO> getEvents();

    List<ParticipantDetailsDTO> getRegisteredParticipants(Long eventId);
  
    List<EventDTO> getEvents(LocalDateTime to, LocalDateTime from, String location, String sortBy);
}