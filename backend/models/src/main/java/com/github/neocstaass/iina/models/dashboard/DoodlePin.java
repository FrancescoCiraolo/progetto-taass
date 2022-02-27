package com.github.neocstaass.iina.models.dashboard;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

/*
Spesa:
- insalata
    - Giovanni
    - Stefano
- formaggio
    [ancora nessuno]
 */
@Entity
public class DoodlePin extends Pin{
    @OneToMany(cascade = CascadeType.ALL)
    private List<DoodlePinItem> items = new java.util.ArrayList<>();

    public List<DoodlePinItem> getItems() {
        return items;
    }

    public void setItems(List<DoodlePinItem> items) {
        this.items = items;
    }
}
