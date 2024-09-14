package com.itschool.eventmanagment.services;

import com.itschool.eventmanagment.models.dtos.EventDTO;
import com.itschool.eventmanagment.models.dtos.UserDTO;

import java.util.List;

public interface UserService {
    List<EventDTO> getUsersEvents();
}