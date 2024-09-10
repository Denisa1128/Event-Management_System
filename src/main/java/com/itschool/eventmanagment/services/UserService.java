package com.itschool.eventmanagment.services;

import com.itschool.eventmanagment.models.dtos.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    List<UserDTO> getUsers();

}
