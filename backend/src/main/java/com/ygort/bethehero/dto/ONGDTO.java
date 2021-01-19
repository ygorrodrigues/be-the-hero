package com.ygort.bethehero.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ygort.bethehero.entities.ONG;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ONGDTO implements Serializable {
    private Long id;
    private String name;
    private String email;
    private String whatsapp;
    private String city;
    private String uf;

    @JsonIgnoreProperties("ong")
    private List<IncidentDTO> incidents = new ArrayList<>();

    public ONGDTO() {}

    public ONGDTO(Long id, String name, String email, String whatsapp, String city, String uf) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.whatsapp = whatsapp;
        this.city = city;
        this.uf = uf;
    }

    public ONGDTO(ONG entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        whatsapp = entity.getWhatsapp();
        city = entity.getCity();
        uf = entity.getUf();
        incidents = entity.getIncidents().stream()
            .map(x -> new IncidentDTO(x)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<IncidentDTO> getIncidents() {
        return incidents;
    }
}
