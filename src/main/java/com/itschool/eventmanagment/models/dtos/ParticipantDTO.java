package com.itschool.eventmanagment.models.dtos;

import com.itschool.eventmanagment.models.entities.Participant;
import lombok.Data;

@Data
public class ParticipantDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    ParticipantDTO() {

    }

    public ParticipantDTO(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public ParticipantDTO(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }



    public static ParticipantDTO fromParticipant(Participant participant) {
        return new ParticipantDTO(participant.getId(), participant.getFirstName(), participant.getLastName(), participant.getEmail());
    }

    public static Participant toParticipant(ParticipantDTO participant) {
        return new Participant(participant.getId(), participant.getFirstName(), participant.getLastName(), participant.getEmail());
    }
}