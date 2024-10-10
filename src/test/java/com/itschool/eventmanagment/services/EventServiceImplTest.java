package com.itschool.eventmanagment.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.eventmanagment.models.dtos.EventDTO;
import com.itschool.eventmanagment.models.dtos.ParticipantDTO;
import com.itschool.eventmanagment.models.entities.Event;
import com.itschool.eventmanagment.models.entities.Participant;
import com.itschool.eventmanagment.models.entities.User;
import com.itschool.eventmanagment.repositories.EventRepository;
import com.itschool.eventmanagment.repositories.UserRepository;
import com.itschool.eventmanagment.services.EventServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EventServiceImplTest {
    @Mock
    private ObjectMapper objectMapper;
    @Mock
    private UserRepository userRepository;
    @Mock
    private EventRepository eventRepository;
    @InjectMocks
    private EventServiceImp eventServiceImp;

    @Test
    void testCreateEvent() {
        LocalDateTime eventDate = LocalDateTime.now();
        EventDTO eventDTO = new EventDTO("music", "Botosani", eventDate, 1L, 10);
        User user = new User();
        user.setId(1l);
        Event event = EventDTO.mapEventDtoToEvent(eventDTO);
        event.setUser(user);
        when(eventRepository.save(event)).thenReturn(new Event(1l, "music", eventDate, "Botosani", 10, user));
        when(userRepository.findById(1l)).thenReturn(Optional.of(user));
        EventDTO response = eventServiceImp.createEvent(eventDTO);
        eventDTO.setId(1L);
        assertEquals(response, eventDTO);
    }

    @Test
    void testUpdateEvent() {
        LocalDateTime eventDate = LocalDateTime.now();
        EventDTO eventDTO = new EventDTO(1L, "music", "Botosani", eventDate, 1L, 10);
        User user = new User();
        user.setId(1l);
        Event event = EventDTO.mapEventDtoToEvent(eventDTO);
        event.setUser(user);
        when(eventRepository.save(event)).thenReturn(new Event(1l, "music", eventDate, "Botosani", 10, user));
        when(userRepository.findById(1l)).thenReturn(Optional.of(user));
        when(eventRepository.findById(1l)).thenReturn(Optional.of(event));
        EventDTO response = eventServiceImp.updateEvent(eventDTO);
        assertEquals(response, eventDTO);
    }
    @Test
    void testGetParticipantsListForEvent(){
        Participant participant = new Participant(1l, "Alina", "Ghetler", "alina@gmail.com");
        List<Participant> panticipants= Arrays.asList(participant);
        User user = new User();
        user.setId(1l);
        Event event = new Event(1L,"music", LocalDateTime.now(), "Botosani", 10, user);
        event.setParticipants(panticipants);
        when(eventRepository.findById(1L)).thenReturn(Optional.of(event));
        List<ParticipantDTO> participantDTOS= eventServiceImp.getRegisteredParticipants(event.getId());
        assertEquals(panticipants.stream().map(participant1 -> ParticipantDTO.fromParticipant(participant1)).toList(), participantDTOS);
    }
}
