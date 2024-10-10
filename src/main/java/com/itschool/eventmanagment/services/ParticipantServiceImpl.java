package com.itschool.eventmanagment.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.eventmanagment.exceptions.ParticipantNotFoundException;
import com.itschool.eventmanagment.models.dtos.ParticipantDTO;
import com.itschool.eventmanagment.models.entities.Participant;
import com.itschool.eventmanagment.repositories.ParticipantRepository;
import org.springframework.stereotype.Service;

@Service
public class ParticipantServiceImpl implements ParticipantService {
    private ObjectMapper objectMapper;
    private ParticipantRepository participantRepository;

    public ParticipantServiceImpl(ObjectMapper objectMapper, ParticipantRepository participantRepository) {
        this.objectMapper = objectMapper;
        this.participantRepository = participantRepository;
    }

    @Override
    public ParticipantDTO createParticipant(ParticipantDTO participantDTO) {
        Participant participantEntityToBeSaved = ParticipantDTO.toParticipant(participantDTO);
        Participant participantResponseEntity = participantRepository.save(participantEntityToBeSaved);
        return ParticipantDTO.fromParticipant(participantResponseEntity);
    }

    @Override
    public void deleteParticipant(Long id) {
        participantRepository.findById(id).orElseThrow(() -> new ParticipantNotFoundException("Participant not found with id"));
        participantRepository.deleteById(id);
    }

    @Override
    public ParticipantDTO updateParticipant(ParticipantDTO participantDTO) {
        Participant participantEntityToBeSaved = objectMapper.convertValue(participantDTO, Participant.class);
        Participant participantResponseEntity = participantRepository.save(participantEntityToBeSaved);
        return objectMapper.convertValue(participantResponseEntity, ParticipantDTO.class);
    }
}
