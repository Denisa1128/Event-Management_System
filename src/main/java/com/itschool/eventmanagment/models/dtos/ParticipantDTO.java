package com.itschool.eventmanagment.models.dtos;


public class ParticipantDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}