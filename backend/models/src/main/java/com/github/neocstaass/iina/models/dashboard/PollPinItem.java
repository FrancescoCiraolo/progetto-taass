package com.github.neocstaass.iina.models.dashboard;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class PollPinItem {
    @Id
    private Long id;
    private String description;
    @ElementCollection
    private List<Long> voters;

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

    public List<Long> getVoters() {
        return voters;
    }

    public void setVoters(List<Long> voters) {
        this.voters = voters;
    }
}
