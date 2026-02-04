package org.example.eventmanagement.service;

import org.example.eventmanagement.dto.EventRequest;
import org.example.eventmanagement.entity.Event;

import java.util.List;

public interface EventService {
    Event createEvent(EventRequest request);
    Event getEventById(Long id);
    List<Event> getAllEvents();
    Event updateEvent(Long id, EventRequest request);
    void deleteEvent(Long id);
}
