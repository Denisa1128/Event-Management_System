package com.itschool.eventmanagment.controllers;

import com.itschool.eventmanagment.models.dtos.EventDTO;
import com.itschool.eventmanagment.services.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventControler {
    private final EventService eventService;
    public EventControler(EventService eventService) {
        this.eventService = eventService;
    }
    @GetMapping("api/events")
    public ResponseEntity<EventDTO> getEvents(){
        return ResponseEntity.ok(eventService.getEvents());
    }
}
