package com.github.neocstaass.iina.dashboards.repositories;

import com.github.neocstaass.iina.models.dashboard.DoodlePin;

import javax.persistence.NoResultException;

public interface DoodlePinRepositoryCustom {
    DoodlePin findByIDFullyLoaded(Long id) throws NoResultException;
}
