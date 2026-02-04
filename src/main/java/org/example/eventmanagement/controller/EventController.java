package org.example.eventmanagement.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.eventmanagement.dto.EventRequest;
import org.example.eventmanagement.entity.Event;
import org.example.eventmanagement.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService service;

    @PostMapping
    public ResponseEntity<Event> create(@Valid @RequestBody EventRequest request) {
        log.info("➡️ Creating event with title: {}", request.getTitle());

        Event event = service.createEvent(request);

        log.info("✅ Event created successfully with id: {}", event.getId());
        return new ResponseEntity<>(event, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getById(@PathVariable Long id) {
        log.info("🔍 Fetching event with id: {}", id);

        Event event = service.getEventById(id);

        log.info("✅ Event found: {}", event.getTitle());
        return ResponseEntity.ok(event);
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAll() {
        log.info("📋 Fetching all events");

        List<Event> events = service.getAllEvents();

        log.info("✅ Total events found: {}", events.size());
        return ResponseEntity.ok(events);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> update(
            @PathVariable Long id,
            @Valid @RequestBody EventRequest request) {

        log.info("✏️ Updating event with id: {}", id);

        Event updatedEvent = service.updateEvent(id, request);

        log.info("✅ Event updated successfully with id: {}", id);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.warn("🗑️ Deleting event with id: {}", id);

        service.deleteEvent(id);

        log.info("✅ Event deleted successfully with id: {}", id);
        return ResponseEntity.noContent().build();
    }
}
