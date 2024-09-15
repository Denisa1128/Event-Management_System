package com.itschool.eventmanagment.services;

import com.itschool.eventmanagment.models.dtos.EventDTO;

import java.time.LocalDateTime;
import java.util.List;
public interface EventService {
    EventDTO createEvent(EventDTO eventDTO);
    List<EventDTO> deleteEvent();
    List<EventDTO> updateEvent();
    List<EventDTO> getEvents(LocalDateTime to, LocalDateTime from, String location, String sortBy);
}