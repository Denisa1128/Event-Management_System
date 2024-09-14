package com.itschool.eventmanagment.repositories;

import com.itschool.eventmanagment.models.entities.Participant;
import com.itschool.eventmanagment.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {

}