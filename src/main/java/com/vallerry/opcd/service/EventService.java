package com.vallerry.opcd.service;

import com.vallerry.opcd.data.EventRepository;
import com.vallerry.opcd.model.Event;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Iterable<Event> findAll() {
        return eventRepository.findAll();
    }
}
