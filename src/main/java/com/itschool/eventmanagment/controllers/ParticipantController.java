package com.itschool.eventmanagment.controllers;

import com.itschool.eventmanagment.models.dtos.ParticipantDTO;
import com.itschool.eventmanagment.services.ParticipantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {
    private final ParticipantService participantService;


    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping("")
    public ResponseEntity<ParticipantDTO> createParticipant(@RequestBody ParticipantDTO participantDTO) {
        return ResponseEntity.ok(participantService.createParticipant(participantDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteParticipant(@PathVariable Long id) {
        participantService.deleteParticipant(id);
        return ResponseEntity.ok("Participant deleted succesfull");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParticipantDTO> updateParticipant(@PathVariable Long id, @RequestBody ParticipantDTO participantDTO) {
        if (id != participantDTO.getId()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        ParticipantDTO updateParticipant = participantService.updateParticipant(participantDTO);
        return ResponseEntity.ok(updateParticipant);
    }
}
