package com.ms.eventservice;


import com.ms.eventservice.models.Event;
import com.ms.eventservice.repository.EventRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
@RefreshScope
public class EventRestAPI {

    @Autowired
    private EventRespository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createProduct(@RequestBody Event event) {
        if (event.getImage() == null || event.getName() == null || event.getDescription() == null) {
            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
        }
        Event e = repository.save(event);
        return new ResponseEntity<Event>(e, HttpStatus.OK);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Event> findAll() {
        return repository.findAll();
    }
}
