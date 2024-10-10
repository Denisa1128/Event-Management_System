package com.itschool.eventmanagment.controllers;

import com.itschool.eventmanagment.models.dtos.EventDTO;
import com.itschool.eventmanagment.models.dtos.UserDTO;
import com.itschool.eventmanagment.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}/events")
    public ResponseEntity<List<EventDTO>> getUserEvents(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserEvents(id));
    }

    @PostMapping("")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }
}