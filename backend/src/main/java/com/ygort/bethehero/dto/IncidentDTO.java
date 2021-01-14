package com.ygort.bethehero.dto;

import com.ygort.bethehero.entities.Incident;
import com.ygort.bethehero.entities.ONG;

import java.io.Serializable;

public class IncidentDTO implements Serializable {
    private Long id;
    private String title;
    private String description;
    private Double value;
    private ONG ong;

    public IncidentDTO() {}

    public IncidentDTO(Long id, String title, String description, Double value) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.value = value;
    }

    public IncidentDTO(Incident entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.value = entity.getValue();
        this.ong = entity.getOng();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public ONG getOng() {
        return ong;
    }
}
