package com.ygort.bethehero.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_incident")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Double value;

    @ManyToOne
    @JoinColumn(name = "ong_id")
    private ONG ong;

    public Incident() {}

    public Incident(Long id, String title, String description, Double value) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.value = value;
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
}
