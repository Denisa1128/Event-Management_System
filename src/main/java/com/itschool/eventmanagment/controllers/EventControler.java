package com.itschool.eventmanagment.controllers;

import com.itschool.eventmanagment.models.dtos.EventDTO;
import com.itschool.eventmanagment.models.entities.Event;
import com.itschool.eventmanagment.services.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class EventControler {
    private final EventService eventService;

    public EventControler(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/api/events")
    public ResponseEntity<EventDTO> createEvent(@RequestBody EventDTO eventDTO) {
        return ResponseEntity.ok(eventService.createEvent(eventDTO));
    }

    @GetMapping("/api/events")
    public ResponseEntity<List<EventDTO>> searchEvent(@RequestParam(required = false) LocalDateTime from, @RequestParam(required = false) LocalDateTime to, @RequestParam(required = false) String location, @RequestParam(required = false) String sortBy) {
        return ResponseEntity.ok(eventService.getEvents(to, from, location, sortBy));
    }
}
