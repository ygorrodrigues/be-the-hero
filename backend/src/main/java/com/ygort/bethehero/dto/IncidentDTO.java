package com.ygort.bethehero.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ygort.bethehero.entities.Incident;
import com.ygort.bethehero.entities.ONG;

import java.io.Serializable;

public class IncidentDTO implements Serializable {
    private Long id;
    private String title;
    private String description;
    private Double value;

    private IncidentOngDTO ong;

    public IncidentDTO() {}

    public IncidentDTO(Long id, String title, String description, Double value) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.value = value;
    }

    public IncidentDTO(Incident entity) {
        id = entity.getId();
        title = entity.getTitle();
        description = entity.getDescription();
        value = entity.getValue();
        ONG ongEntity = entity.getOng();
        ong = new IncidentOngDTO(ongEntity);
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

    public IncidentOngDTO getOng() {
        return ong;
    }

    private class IncidentOngDTO {
        private Long id;
        private String name;
        private String email;
        private String whatsapp;
        private String city;
        private String uf;

        public IncidentOngDTO() {}

        public IncidentOngDTO(Long id, String name, String email, String whatsapp, String city, String uf) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.whatsapp = whatsapp;
            this.city = city;
            this.uf = uf;
        }

        public IncidentOngDTO(ONG ong) {
            this.id = ong.getId();
            this.name = ong.getName();
            this.email = ong.getEmail();
            this.whatsapp = ong.getWhatsapp();
            this.city = ong.getCity();
            this.uf = ong.getUf();
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
    }
}

