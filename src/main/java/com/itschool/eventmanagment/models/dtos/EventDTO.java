package com.itschool.eventmanagment.models.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.itschool.eventmanagment.models.entities.Participant;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class EventDTO {
    private Long id;

    private String name;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dateTime;

    private String location;

    private Long userId;

    private int maxParticipants;

    private List<Participant> registeredParticipants = new ArrayList<>();
}
