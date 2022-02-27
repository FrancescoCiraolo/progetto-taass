package com.github.neocstaass.iina.events.repositories;

import com.github.neocstaass.iina.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
