package com.ygort.bethehero.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_ong")
public class ONG implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private String whatsapp;
    private String city;
    private String uf;

    @OneToMany
    @JoinColumn(name = "ong_id")
    private Set<Incident> incidents = new HashSet<>();

    public ONG() {}

    public ONG(Long id, String name, String email, String whatsapp, String city, String uf) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.whatsapp = whatsapp;
        this.city = city;
        this.uf = uf;
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

    public Set<Incident> getIncidents() {
        return incidents;
    }
}
