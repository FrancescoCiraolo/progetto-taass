package com.github.neocstaass.iina.dashboards.repositories;

import com.github.neocstaass.iina.models.dashboard.PollPin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollPinRepository extends JpaRepository<PollPin, Long> {
}
