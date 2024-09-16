package com.itschool.eventmanagment.services;

import com.itschool.eventmanagment.models.dtos.EventDTO;
import org.springframework.stereotype.Service;

import java.util.List;
public interface EventService {
    EventDTO createEvent(EventDTO eventDTO);

    List<EventDTO> deleteEvent();

    List<EventDTO> updateEvent();

    List<EventDTO> getEvents();
}