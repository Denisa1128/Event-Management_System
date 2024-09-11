package com.itschool.eventmanagment.controllers;

import com.itschool.eventmanagment.models.dtos.EventDTO;
import com.itschool.eventmanagment.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("api/users/{id}/events")
    public ResponseEntity<List<EventDTO>> getUserEvents(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUsersEvents());
    }
}
