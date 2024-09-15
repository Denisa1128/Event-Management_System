package com.itschool.eventmanagment.controllers;

import com.itschool.eventmanagment.models.dtos.EventDTO;
import com.itschool.eventmanagment.models.dtos.UserDTO;
import com.itschool.eventmanagment.models.entities.User;
import com.itschool.eventmanagment.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("api/users/{id}/events")
    public ResponseEntity<List<EventDTO>> getUserEvents(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserEvents(id));
    }

    @PostMapping("api/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }
}

