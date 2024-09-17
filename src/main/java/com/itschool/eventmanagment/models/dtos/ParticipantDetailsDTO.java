package com.itschool.eventmanagment.models.dtos;

import lombok.Data;

@Data
public class ParticipantDetailsDTO {
    private String firstName;
    private String lastName;
    private String email;

    public ParticipantDetailsDTO(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}