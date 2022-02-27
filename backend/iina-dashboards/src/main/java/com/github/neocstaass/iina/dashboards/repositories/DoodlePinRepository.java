package com.github.neocstaass.iina.dashboards.repositories;

import com.github.neocstaass.iina.models.dashboard.DoodlePin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoodlePinRepository extends JpaRepository<DoodlePin, Long>, DoodlePinRepositoryCustom {
}
