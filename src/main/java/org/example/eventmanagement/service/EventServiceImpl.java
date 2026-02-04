package org.example.eventmanagement.service;

import lombok.RequiredArgsConstructor;
import org.example.eventmanagement.dto.EventRequest;
import org.example.eventmanagement.entity.Event;
import org.example.eventmanagement.exception.EventNotFoundException;
import org.example.eventmanagement.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    @Autowired
    private  EventRepository repository;



    @Override
    public Event createEvent(EventRequest request) {

        Event event = new Event();
        event.setTitle(request.getTitle());
        event.setDescription(request.getDescription());
        event.setEventDate(request.getEventDate());
        event.setLocation(request.getLocation());

        return repository.save(event);  // ✅ IMPORTANT
    }


    @Override
    public Event getEventById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EventNotFoundException("Event not found: " + id));
    }

    @Override
    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    @Override
    public Event updateEvent(Long id, EventRequest request) {
        Event event = getEventById(id);
        event.setTitle(request.getTitle());
        event.setDescription(request.getDescription());
        event.setEventDate(request.getEventDate());
        event.setLocation(request.getLocation());
        return repository.save(event);
    }

    @Override
    public void deleteEvent(Long id) {
        repository.delete(getEventById(id));
    }
}
