package com.itschool.eventmanagment.services;

import com.itschool.eventmanagment.models.dtos.ParticipantDTO;

public interface ParticipantService {
    ParticipantDTO createParticipant(ParticipantDTO participantDTO);
    void deleteParticipant(Long id);

    ParticipantDTO updateParticipant(ParticipantDTO participantDTO);

}
