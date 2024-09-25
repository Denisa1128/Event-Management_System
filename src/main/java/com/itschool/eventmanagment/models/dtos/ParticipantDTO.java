package com.itschool.eventmanagment.models.dtos;

import lombok.Data;

@Data
public class ParticipantDTO {
    private String firstName;
    private String lastName;
    private String email;

    public ParticipantDTO(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}