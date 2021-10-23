package com.ms.eventservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.eventservice.models.Event;

public interface EventRespository extends JpaRepository<Event, String> {

}
