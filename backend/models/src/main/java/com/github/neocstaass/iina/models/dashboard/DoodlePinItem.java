package com.github.neocstaass.iina.models.dashboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class DoodlePinItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    private String description;
    @NotNull
    @Min(1)
    private Long maximumParticipants;
    @ElementCollection
    private Set<Long> participants;

    public DoodlePinItem() {
    }

    public DoodlePinItem(String description, Long maximumParticipants) {
        this.description = description;
        this.maximumParticipants = maximumParticipants;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Long> getParticipants() {
        return participants;
    }

    public Long getMaximumParticipants() {
        return maximumParticipants;
    }

    public void setMaximumParticipants(Long maximumUsers) {
        this.maximumParticipants = maximumUsers;
    }

    public void setParticipants(Set<Long> participants) {
        this.participants = participants;
    }

    public void addParticipant(Long userID) {
        participants.add(userID);
    }

    public void removeParticipant(Long userID) {
        participants.remove(userID);
    }

    public int getParticipantsCount() {
        return participants.size();
    }
}