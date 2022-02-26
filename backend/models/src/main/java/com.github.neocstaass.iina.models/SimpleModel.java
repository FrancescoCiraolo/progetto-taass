package com.github.neocstaass.iina.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SimpleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
