package com.itschool.eventmanagment.services;

import com.itschool.eventmanagment.exceptions.EventNotFoundException;
import com.itschool.eventmanagment.models.dtos.EventDTO;
import com.itschool.eventmanagment.models.dtos.ParticipantDTO;
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
        Event eventEntityToBeSaved = EventDTO.mapEventDtoToEvent(eventDTO);
        eventEntityToBeSaved.setUser(user);
        Event eventResponseEntity = eventRepository.save(eventEntityToBeSaved);
        return EventDTO.mapEventToEventDto(eventResponseEntity);
    }

    @Override
    public void  deleteEvent(Long id) {
    Event event = eventRepository.findById(id).orElseThrow(()-> new EventNotFoundException("Event not found with id: " + id ));
    eventRepository.deleteById(id);
    }

    @Override
    public EventDTO updateEvent(EventDTO eventDTO) {
        Event event= eventRepository.findById(eventDTO.getId()).orElseThrow(()->  new EventNotFoundException("Event not found with id: "));
        Event eventEntityBeUpdated = EventDTO.mapEventDtoToEvent(eventDTO);
        User user= userRepository.findById(eventDTO.getUserId()).orElseThrow();
        eventEntityBeUpdated.setUser(user);
        Event eventResponseEntity = eventRepository.save(eventEntityBeUpdated);
        return EventDTO.mapEventToEventDto(eventResponseEntity);
    }

    @Override
    public List<EventDTO> getEvents() {
        return eventRepository.findAll().stream().map(EventDTO::mapEventToEventDto).toList();
    }

    @Override
    public List<EventDTO> getEvents(LocalDateTime to, LocalDateTime from, String location, String sortBy) {
        List<Event> events;
        if ("location".equalsIgnoreCase(sortBy)) {
            events = eventRepository.findByEventDateTimeBetweenAndLocationContainingIgnoreCaseOrderByLocationAsc(to, from, location);
        } else {
            events = eventRepository.findByEventDateTimeBetweenAndLocationContainingIgnoreCaseOrderByEventDateTime(to, from, location);
        }
        return events.stream().map(EventDTO::mapEventToEventDto).toList();
    }

    @Override
    public List<ParticipantDTO> getRegisteredParticipants(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Event not found id: " + eventId));
        return mapParticipantsToDTOs(event.getParticipants());
    }

    public List<ParticipantDTO> mapParticipantsToDTOs(List<Participant> participants) {
        return participants.stream()
                .map(participant -> new ParticipantDTO(
                        participant.getId(),
                        participant.getFirstName(),
                        participant.getLastName(),
                        participant.getEmail()
                ))
                .toList();
    }
}