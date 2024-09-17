package com.itschool.eventmanagment.services;

import com.itschool.eventmanagment.models.dtos.DetailsParticipantDTO;
import com.itschool.eventmanagment.models.dtos.EventDTO;
import com.itschool.eventmanagment.models.dtos.ParticipantDTO;
import com.itschool.eventmanagment.models.entities.Event;
import com.itschool.eventmanagment.models.entities.Participant;
import com.itschool.eventmanagment.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventServiceImp implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public EventDTO createEvent(EventDTO eventDTO) {
        return null;
    }

    @Override
    public List<EventDTO> deleteEvent() {
        return null;
    }

    @Override
    public List<EventDTO> updateEvent() {
        return null;
    }

    @Override
    public List<EventDTO> getEvents() {
        return null;
    }

    @Override
    public List<DetailsParticipantDTO> getRegisteredParticipants(Long eventId) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);
        List<DetailsParticipantDTO> detailsParticipantDTOList = new ArrayList<>();

        if (eventOptional.isPresent()) {
            Event event = eventOptional.get();
            List<Participant> participants = event.getParticipants();

            if (participants == null) {
                return detailsParticipantDTOList;
            }

            for (Participant participant : participants) {
                DetailsParticipantDTO detailsParticipantDTO = new DetailsParticipantDTO();
                detailsParticipantDTO.setFirstName(participant.getFirstName());
                detailsParticipantDTO.setLastName(participant.getLastName());
                detailsParticipantDTO.setEmail(participant.getEmail());

                detailsParticipantDTOList.add(detailsParticipantDTO);
            }
            return detailsParticipantDTOList;
        }
        return detailsParticipantDTOList;
    }
}