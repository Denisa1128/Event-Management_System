package com.itschool.eventmanagment.controllers;

import com.itschool.eventmanagment.models.dtos.EventDTO;
import com.itschool.eventmanagment.services.EventService;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
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
    public ResponseEntity<List<EventDTO>> getFilteredAndSortedEvents(@RequestParam @NotNull(message = "from date is mandatory") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
                                                                     @RequestParam @NotNull(message = "to is mandatory") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to,
                                                                     @RequestParam @NotNull(message = "location is mandatory") String location,
                                                                     @RequestParam(required = false) String sortBy) {
        return ResponseEntity.ok(eventService.getEvents(to, from, location, sortBy));
    }
}
