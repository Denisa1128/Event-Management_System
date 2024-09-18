package com.itschool.eventmanagment.services;

import com.itschool.eventmanagment.models.dtos.EventDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    List<EventDTO> getUserEvents(Long id);
}