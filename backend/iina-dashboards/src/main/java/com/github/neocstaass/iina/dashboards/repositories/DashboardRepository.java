package com.github.neocstaass.iina.dashboards.repositories;

import com.github.neocstaass.iina.models.dashboard.Pin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DashboardRepository extends JpaRepository<Pin, Long> {
}
