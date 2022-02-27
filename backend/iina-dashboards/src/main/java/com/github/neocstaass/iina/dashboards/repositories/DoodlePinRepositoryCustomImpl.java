package com.github.neocstaass.iina.dashboards.repositories;

import com.github.neocstaass.iina.models.dashboard.DoodlePin;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

public class DoodlePinRepositoryCustomImpl implements DoodlePinRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public DoodlePin findByIDFullyLoaded(Long id) throws NoResultException {
        return entityManager.createQuery("""
                                             select dp
                                             from DoodlePin dp
                                             left join fetch dp.items
                                             where dp.id = :id
                                             """, DoodlePin.class)
                            .setParameter("id", id)
                            .getSingleResult();
    }
}
