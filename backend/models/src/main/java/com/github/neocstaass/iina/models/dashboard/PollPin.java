package com.github.neocstaass.iina.models.dashboard;

import javax.persistence.*;
import java.util.List;

@Entity
public class PollPin extends Pin {
    @OneToMany(fetch = FetchType.LAZY)
    private List<PollPinItem> items;

    public List<PollPinItem> getItems() {
        return items;
    }

    public void setItems(List<PollPinItem> items) {
        this.items = items;
    }
}
