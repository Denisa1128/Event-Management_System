package com.example.event_project.services;

import com.example.event_project.models.dtos.ParticipantDTO;
import com.example.event_project.models.entities.Participant;
import com.example.event_project.repositories.ParticipantRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository participantRepository;
    private final ObjectMapper objectMapper;
    public ParticipantServiceImpl(ParticipantRepository participantRepository, ObjectMapper objectMapper) {
        this.participantRepository = participantRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public ParticipantDTO createParticipant(ParticipantDTO participantDTO) {
        Participant participantToBeSaved = objectMapper.convertValue(participantDTO, Participant.class);
        Participant participantResposeEntity = participantRepository.save(participantToBeSaved);
        return objectMapper.convertValue(participantResposeEntity, ParticipantDTO.class);
    }
}