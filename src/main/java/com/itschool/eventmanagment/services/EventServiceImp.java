package com.itschool.eventmanagment.services;

import com.itschool.eventmanagment.exceptions.EventNotFoundException;
import com.itschool.eventmanagment.models.dtos.EventDTO;
import com.itschool.eventmanagment.models.dtos.ParticipantDetailsDTO;
import com.itschool.eventmanagment.models.entities.Event;
import com.itschool.eventmanagment.models.entities.Participant;
import com.itschool.eventmanagment.models.entities.User;
import com.itschool.eventmanagment.repositories.EventRepository;
import com.itschool.eventmanagment.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventServiceImp implements EventService {


    private final UserRepository userRepository;
    private final EventRepository eventRepository;


    public EventServiceImp(UserRepository userRepository, EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public EventDTO createEvent(EventDTO eventDTO) {
        User user = userRepository.findById(eventDTO.getUserId()).orElseThrow(() -> new RuntimeException("User with id " + eventDTO.getUserId() + "not found"));
        Event eventEntityToBeSaved = mapEventDtoToEvent(eventDTO);
        eventEntityToBeSaved.setUser(user);
        Event eventResponseEntity = eventRepository.save(eventEntityToBeSaved);
        return mapEventToEventDto(eventResponseEntity);
    }

    @Override
    public List<EventDTO> deleteEvent() {
        return null;
    }

    @Override
    public List<EventDTO> updateEvent(EventDTO eventDTO) {
        return null;
    }

    @Override
    public List<EventDTO> getEvents() {
        return eventRepository.findAll().stream().map(EventServiceImp::mapEventToEventDto).toList();
    }

    @Override
    public List<EventDTO> getEvents(LocalDateTime to, LocalDateTime from, String location, String sortBy) {
        List<Event> events;
        if ("location".equalsIgnoreCase(sortBy)) {
            events = eventRepository.findByEventDateTimeBetweenAndLocationContainingIgnoreCaseOrderByLocationAsc(to, from, location);
        } else {
            events = eventRepository.findByEventDateTimeBetweenAndLocationContainingIgnoreCaseOrderByEventDateTime(to, from, location);
        }
        return events.stream().map(EventServiceImp::mapEventToEventDto).toList();
    }

    public static EventDTO mapEventToEventDto(Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setEventDateTime(event.getEventDateTime());
        eventDTO.setName(event.getName());
        eventDTO.setLocation(event.getLocation());
        eventDTO.setUserId(event.getUser().getId());
        eventDTO.setMaxParticipants(event.getMaxParticipants());
        return eventDTO;
    }

   public static Event mapEventDtoToEvent(EventDTO eventDTO) {
        Event event = new Event();
        event.setId(eventDTO.getId());
        event.setEventDateTime(eventDTO.getEventDateTime());
        event.setName(eventDTO.getName());
        event.setLocation(eventDTO.getLocation());
        event.setMaxParticipants(eventDTO.getMaxParticipants());
        return event;
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
                .toList();
    }
}