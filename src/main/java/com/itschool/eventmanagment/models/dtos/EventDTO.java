package com.itschool.eventmanagment.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.itschool.eventmanagment.models.entities.Participant;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class EventDTO {
    private Long id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;
    private String location;
    private int maxParticipants;
    private List<Participant> registeredParticipants = new ArrayList<>();
}
