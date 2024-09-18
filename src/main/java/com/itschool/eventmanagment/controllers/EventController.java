package com.itschool.eventmanagment.controllers;


import com.itschool.eventmanagment.models.dtos.ParticipantDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
public class EventController {
    @Autowired
    private final EventService eventService;
  
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("api/events")
    public ResponseEntity<List<EventDTO>> getEvents() {
        return ResponseEntity.ok(eventService.getEvents());
    }

    @GetMapping("events/{id}/participants")
    public ResponseEntity<List<ParticipantDetailsDTO>> getRegisteredParticipants(@PathVariable("id") Long eventId) {
        return ResponseEntity.ok(eventService.getRegisteredParticipants(eventId));
    }
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