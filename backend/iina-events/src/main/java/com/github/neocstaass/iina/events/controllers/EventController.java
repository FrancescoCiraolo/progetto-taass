package com.github.neocstaass.iina.events.controllers;

import com.github.neocstaass.iina.events.repositories.EventRepository;
import com.github.neocstaass.iina.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.Date;

@CrossOrigin
@RestController
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @PostMapping("/add-event")
    @ResponseStatus(HttpStatus.CREATED)
    public Event addEvent(@Valid @RequestBody Event event) {
        return this.eventRepository.save(event);
    }

    @PostMapping("/edit-name")
    @ResponseStatus(HttpStatus.OK)
    public Event editName(@RequestParam Long id, @RequestParam String name) {
        Event event;
        try {
            event = eventRepository.getById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        event.setName(name);
        return eventRepository.save(event);
    }

    @PostMapping("/edit-description")
    @ResponseStatus(HttpStatus.OK)
    public Event editDescription(@RequestParam Long id, @RequestParam String description) {
        Event event;
        try {
            event = eventRepository.getById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        event.setDescription(description);
        return eventRepository.save(event);
    }

    @PostMapping("/edit-deadline")
    @ResponseStatus(HttpStatus.OK)
    public Event editDeadline(@RequestParam Long id,
                              @RequestParam
                              @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                                  Date expiration) {
        Event event;
        try {
            event = eventRepository.getById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        event.setExpiration(expiration);
        return eventRepository.save(event);
    }

    @PostMapping("/edit-status")
    @ResponseStatus(HttpStatus.OK)
    public Event editStatus(@RequestParam Long id, @RequestParam int status) {
        Event event;
        try {
            event = eventRepository.getById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        // todo add business rule to check if we can change the status

        if (status < 0 || status > Event.Status.values().length - 1)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        event.setStatus(Event.Status.values()[status]);
        return eventRepository.save(event);
    }

}
