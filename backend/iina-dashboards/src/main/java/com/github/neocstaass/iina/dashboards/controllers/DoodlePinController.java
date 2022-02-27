package com.github.neocstaass.iina.dashboards.controllers;

import com.github.neocstaass.iina.dashboards.repositories.DoodlePinItemRepository;
import com.github.neocstaass.iina.dashboards.repositories.DoodlePinRepository;
import com.github.neocstaass.iina.models.dashboard.DoodlePin;
import com.github.neocstaass.iina.models.dashboard.DoodlePinItem;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController
public class DoodlePinController {

    Logger logger = LoggerFactory.getLogger(DoodlePinController.class);

    @Autowired
    private DoodlePinRepository doodlePinRepository;
    @Autowired
    private DoodlePinItemRepository doodlePinItemRepository;

    @PostMapping("add-doodle")
    @ResponseStatus(HttpStatus.CREATED)
    public DoodlePin addDoodlePin(@RequestBody @Valid DoodlePin pin) {
        return doodlePinRepository.save(pin);
    }

    @Transactional
    @Validated
    @GetMapping(value = "get-doodle")
    public DoodlePin getDoodlePin(@RequestParam @NotNull @Min(0) Long id) {
        try {
            return doodlePinRepository.findByIDFullyLoaded(id);
        } catch (NoResultException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("delete-doodle")
    @ResponseStatus(HttpStatus.OK)
    public void removeDoodlePin(@RequestParam @NotNull @Min(0) Long id) {
        doodlePinRepository.deleteById(id);
    }

    //todo fix null error
    @PostMapping("add-pin-item")
    @Transactional
    public DoodlePin addPinItem(@RequestBody NewPinItem newPinItemData) {
        DoodlePin doodlePin = doodlePinRepository.getById(newPinItemData.doodlePinId);
        DoodlePinItem newItem = doodlePinItemRepository.save(new DoodlePinItem(newPinItemData.description,
                                                                               newPinItemData.doodlePinId));
        doodlePin.getItems().add(newItem);
        return doodlePinRepository.save(doodlePin);
    }



    private record NewPinItem(Long doodlePinId, String description, Long maximumParticipants) {}
}
