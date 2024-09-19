package com.itschool.eventmanagment.models.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
}