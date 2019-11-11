package com.hooli.railways.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STATIONS_ROUTES")
public class StationsRoutes {
    @Id
    @Column(name="ID")
    private Integer id;
    @Column(name="ROUTE_ID")
    private Integer routeId;
    @Column(name="STATION_NAME")
    private String stationName;
    @Column(name="ARRIVAL")
    private Integer arrival;
    @Column(name="TIME")
    private Integer time;
    @Column(name = "STATION_NUMBER")
    private Integer stationNumber;
    @Column(name = "PRICE")
    private Integer price;

    public StationsRoutes() {
    }

    public StationsRoutes(Integer id, Integer routeId, String stationName, Integer arrival, Integer time, Integer stationNumber, Integer price) {
        this.id = id;
        this.routeId = routeId;
        this.stationName = stationName;
        this.arrival = arrival;
        this.time = time;
        this.stationNumber = stationNumber;
        this.price = price;
    }

    public Integer getStationNumber() {
        return stationNumber;
    }

    public void setStationNumber(Integer stationNumber) {
        this.stationNumber = stationNumber;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public Integer getArrival() {
        return arrival;
    }

    public void setArrival(Integer arrival) {
        this.arrival = arrival;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
