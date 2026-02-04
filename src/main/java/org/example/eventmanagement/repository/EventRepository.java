package org.example.eventmanagement.repository;

import org.example.eventmanagement.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
