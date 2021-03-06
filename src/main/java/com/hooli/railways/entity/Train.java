package com.hooli.railways.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRAIN")
public class Train {
    @Id
    @Column(name="ID")
    private Integer id;
    @Column(name="DEPARTURE")
    private Integer departure;
    @Column(name="ROUTE_ID")
    private Integer routeId;
    @Column(name = "NUMBER_OF_SEATS")
    private Integer seats;

    public Train() {
    }

    public Train(Integer id, Integer departure, Integer routeId, Integer seats) {
        this.seats = seats;
        this.id = id;
        this.departure = departure;
        this.routeId = routeId;
    }


    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeparture() {
        return departure;
    }

    public void setDeparture(Integer departure) {
        this.departure = departure;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }
}
