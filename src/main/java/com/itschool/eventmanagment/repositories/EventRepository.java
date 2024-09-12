package com.itschool.eventmanagment.repositories;

import com.itschool.eventmanagment.models.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long > {
}
