package com.hooli.railways.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROUTE")
public class Route {
    @Id
    @Column(name="ID")
    private Integer id;
    @Column(name="ORIGIN")
    private String origin;
    @Column(name="DESTINATION")
    private String destionation;
    @Column(name="STATIONS")
    private Integer stations;

    public Route() {

    }

    public Route(Integer id, String origin, String destionation, Integer stations) {
        this.id = id;
        this.origin = origin;
        this.destionation = destionation;
        this.stations = stations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestionation() {
        return destionation;
    }

    public void setDestionation(String destionation) {
        this.destionation = destionation;
    }


    public Integer getStations() {
        return stations;
    }

    public void setStations(Integer stations) {
        this.stations = stations;
    }
}

