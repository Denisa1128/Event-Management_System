package com.itschool.eventmanagment.models.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itschool.eventmanagment.models.entities.Event;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class EventDTO {
    private Long id;
    private String name;
    private String location;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime eventDateTime;
    private Long userId;
    private int maxParticipants;
    private List<ParticipantDTO> registeredParticipants = new ArrayList<>();

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
}