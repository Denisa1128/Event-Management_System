package com.itschool.eventmanagment.models.dtos;

import com.itschool.eventmanagment.models.entities.Participant;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class EventDTO {
    private Long id;
    private String name;
    private LocalDateTime dateTime;
    private String location;
    private int maxParticipants;
    private List<Participant> registeredParticipants = new ArrayList<>();
}