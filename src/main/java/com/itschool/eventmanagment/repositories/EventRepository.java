package com.itschool.eventmanagment.repositories;

import com.itschool.eventmanagment.models.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByEventDateTimeBetweenAndLocationContainingIgnoreCaseOrderByEventDateTime(LocalDateTime from, LocalDateTime to, String location);
    List<Event> findByEventDateTimeBetweenAndLocationContainingIgnoreCaseOrderByLocationAsc(LocalDateTime from, LocalDateTime to, String location);
    List<Event> findByUserId(Long userId);
}