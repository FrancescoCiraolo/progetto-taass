package com.github.neocstaass.iina.models;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Event {

    public enum Status {
        ACTIVE,
        ENDED,
        CLOSED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Min(0)
    private Long creatorID;
    @NotNull
    @Min(0)
    private Long groupId;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    private String description;
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Status status;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    Date expiration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(Long creatorId) {
        this.creatorID = creatorId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
}
