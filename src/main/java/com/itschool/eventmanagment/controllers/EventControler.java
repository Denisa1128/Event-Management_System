package com.itschool.eventmanagment.controllers;

import com.itschool.eventmanagment.models.dtos.EventDTO;
import com.itschool.eventmanagment.services.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventControler {
    private final EventService eventService;

    public EventControler(EventService eventService) {
        this.eventService = eventService;
    }
    @PostMapping("/api/events")
    public ResponseEntity<EventDTO> createEvent(@RequestBody EventDTO eventDTO){
        return ResponseEntity.ok(eventService.createEvent(eventDTO));
    }
}
