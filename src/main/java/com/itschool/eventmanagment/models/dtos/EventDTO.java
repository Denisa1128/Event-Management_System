package com.itschool.eventmanagment.models.dtos;

import com.itschool.eventmanagment.models.entities.Participant;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class EventDTO {
    private Long Id;
    private String name;
    private LocalDateTime dateTime;
    private String location;
    private Long userId;

    private int maxParticipants;
    private List<Participant> registeredParticipants = new ArrayList<>();
}
