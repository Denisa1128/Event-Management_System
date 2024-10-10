package com.itschool.eventmanagment.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.eventmanagment.models.dtos.ParticipantDTO;
import com.itschool.eventmanagment.models.entities.Participant;
import com.itschool.eventmanagment.repositories.ParticipantRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ParticipantServiceImplTest {

    @Mock
    ObjectMapper objectMapper;
    @Mock
    private ParticipantRepository participantRepository;
    @InjectMocks
    private ParticipantServiceImpl participantService;

    @Test
    void testCreateParticipant() {
        ParticipantDTO participantDTO = new ParticipantDTO("Alina", "Ghetler", "alina@gmail.com");
        when(participantRepository.save(ParticipantDTO.toParticipant(participantDTO))).thenReturn(new Participant(1L, "Alina", "Ghetler", "alina@gmail.com"));
        ParticipantDTO response = participantService.createParticipant(participantDTO);
        participantDTO.setId(1L);
        assertEquals(response, participantDTO);
    }
    @Test
    void testUpdateParticipant(){
        ParticipantDTO participantDTO = new ParticipantDTO(1l, "Alina", "Ghetler", "alina@gmail.com");
        Participant participant = new Participant(1L, "Alina", "Ghetler", "alina@gmail.com");
        when(objectMapper.convertValue(participantDTO, Participant.class)).thenReturn(participant);
        when(participantRepository.save(ParticipantDTO.toParticipant(participantDTO))).thenReturn(participant);
        when(objectMapper.convertValue(participant, ParticipantDTO.class)).thenReturn(participantDTO);
        ParticipantDTO response = participantService.updateParticipant(participantDTO);
        assertEquals(participantDTO, response);
    }
}
