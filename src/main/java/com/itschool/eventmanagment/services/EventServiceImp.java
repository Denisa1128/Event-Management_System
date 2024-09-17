package com.itschool.eventmanagment.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.eventmanagment.models.dtos.EventDTO;
import com.itschool.eventmanagment.models.entities.Event;
import com.itschool.eventmanagment.models.entities.User;
import com.itschool.eventmanagment.repositories.EventRepository;
import com.itschool.eventmanagment.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImp implements EventService {


    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;
    private final EventRepository eventRepository;


    public EventServiceImp(UserRepository userRepository, ObjectMapper objectMapper, EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
        this.eventRepository = eventRepository;
    }

    @Override
    public EventDTO createEvent(EventDTO eventDTO) {
        User user = userRepository.findById(eventDTO.getUserId()).orElseThrow(() -> new RuntimeException("User with id " + eventDTO.getUserId() + "not found"));
        Event eventEntityToBeSaved = objectMapper.convertValue(eventDTO, Event.class);
        eventEntityToBeSaved.setUser(user);
        Event eventResponseEntity = eventRepository.save(eventEntityToBeSaved);
        EventDTO returnDTO = objectMapper.convertValue(eventResponseEntity, EventDTO.class);
        returnDTO.setUserId(eventResponseEntity.getUser().getId());
        return returnDTO;
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
    public List<EventDTO> getEvents(LocalDateTime to, LocalDateTime from, String location, String sortBy) {
        List<Event> events;
        if ("location".equalsIgnoreCase(sortBy)) {
            events = eventRepository.findByDateTimeBetweenAndLocationContainingIgnoreCaseOrderByLocationAsc(to, from, location);
        } else {
            events = eventRepository.findByDateTimeBetweenAndLocationContainingIgnoreCaseOrderByDateTime(to, from, location);
        }
        return events.stream().map(event -> objectMapper.convertValue(event, EventDTO.class)).collect(Collectors.toList());
    }
}


