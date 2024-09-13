package com.itschool.eventmanagment.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.eventmanagment.models.dtos.EventDTO;
import com.itschool.eventmanagment.models.entities.Event;
import com.itschool.eventmanagment.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImp implements EventService {
    /**
     *
     */
    private final EventRepository eventRepository;
    private final ObjectMapper objectMapper;

    public EventServiceImp(EventRepository eventRepository, ObjectMapper objectMapper) {
        this.eventRepository = eventRepository;
        this.objectMapper = objectMapper;
    }


    @Override
    public EventDTO createEvent(EventDTO eventDTO) {
        Event eventEntityToBeSaved = objectMapper.convertValue(eventDTO, Event.class);
        Event eventResponseEntity = eventRepository.save(eventEntityToBeSaved);
        return objectMapper.convertValue(eventResponseEntity, EventDTO.class);
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
}
