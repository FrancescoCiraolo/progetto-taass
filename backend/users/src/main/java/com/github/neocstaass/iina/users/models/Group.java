package com.github.neocstaass.iina.users.models;

import java.util.List;
import java.util.Set;

public class Group implements EconomicEntity {

    /**
     * Group's members set, implemented ad List because JSON has no support
     * for sets.
     */
    private List<User> members;

    private User admin;

    /**
     * Could be null if it is a user generated group; if it was automatic generated to solve
     * transactions it will be destroyed, or archived, when the event is closed.
     */
    private String masterEvent;

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public String getMasterEvent() {
        return masterEvent;
    }

    public void setMasterEvent(String masterEvent) {
        this.masterEvent = masterEvent;
    }
}
