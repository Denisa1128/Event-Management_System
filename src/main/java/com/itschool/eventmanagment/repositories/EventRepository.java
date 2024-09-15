package com.itschool.eventmanagment.repositories;

import com.itschool.eventmanagment.models.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long > {
    List<Event> findByDateTimeBetweenOrLocationContainingIgnoreCaseOrderByDateTime(LocalDateTime fromDateTime, LocalDateTime toDateTime, String location);
    List<Event> findByDateTimeBetweenOrLocationContainingIgnoreCaseOrderByLocationAsc(LocalDateTime fromDateTime, LocalDateTime toDateTime, String location);

}
