package com.itschool.eventmanagment.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.eventmanagment.models.dtos.EventDTO;
import com.itschool.eventmanagment.models.dtos.UserDTO;
import com.itschool.eventmanagment.models.entities.Event;
import com.itschool.eventmanagment.models.entities.User;
import com.itschool.eventmanagment.repositories.EventRepository;
import com.itschool.eventmanagment.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final ObjectMapper objectMapper;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public UserServiceImpl(ObjectMapper objectMapper, UserRepository userRepository, EventRepository eventRepository) {
        this.objectMapper = objectMapper;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    public UserDTO createUser(UserDTO userDTO) {
        User userEntityToBESaved = objectMapper.convertValue(userDTO, User.class);
        User userResponseEntity = userRepository.save(userEntityToBESaved);
        return objectMapper.convertValue(userResponseEntity, UserDTO.class);
    }

    public List<EventDTO> getUserEvents(Long id) {
        Optional<User> userWithEvent = userRepository.findById(id);
        if (!userWithEvent.isPresent()) {
            throw new RuntimeException("User with ID " + id + " not found");
        }

        User user = userWithEvent.get();
        List<Event> events = eventRepository.findByUserId(id);
        List<EventDTO> listEvents = events.stream()
                .map(event -> objectMapper.convertValue(event, EventDTO.class))
                .toList();
        listEvents.forEach(eventDTO -> eventDTO.setUserId(user.getId()));
        return listEvents;
    }
}
