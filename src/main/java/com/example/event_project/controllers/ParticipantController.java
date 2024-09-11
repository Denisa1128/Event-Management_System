package com.example.event_project.controllers;

import com.example.event_project.models.dtos.ParticipantDTO;
import com.example.event_project.services.ParticipantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }
    @PostMapping("/api/participants")
    public ResponseEntity<ParticipantDTO> createParticipant(@RequestBody ParticipantDTO participantDTO) {
        return ResponseEntity.ok(participantService.createParticipant(participantDTO));
    }
}