package com.itschool.eventmanagment.repositories;

import com.itschool.eventmanagment.models.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long > {
}
