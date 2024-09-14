package com.itschool.eventmanagment.models.dtos;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    private Set<EventDTO> managedEvent = new HashSet();
}