package com.hooli.railways.entity;

import java.util.Arrays;

public class TrainFront {

    private Integer id;
    private Integer routeId;
    private Integer departure;
    private Integer arrival;
    private Integer price;
    private Integer start;
    private Integer end;
    private Boolean[] seats;

    public TrainFront(Integer id, Integer routeId, Integer departure, Integer arrival, Integer price, Integer start, Integer end, Integer seats) {
        this.id = id;
        this.routeId = routeId;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
        this.start = start;
        this.end = end;
        this.seats = new Boolean[seats];
        Arrays.fill(this.seats, true);
    }

    public TrainFront() {
    }

    public Boolean[] getSeats() {
        return seats;
    }

    public void setSeats(Boolean[] seats) {
        this.seats = seats;
    }

    public void setSeatFalse(Integer seat) {
        this.seats[seat] = false;
    }

    public Boolean getSeat(int seat) {
        return seats[seat];
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getDeparture() {
        return departure;
    }

    public void setDeparture(Integer departure) {
        this.departure = departure;
    }

    public Integer getArrival() {
        return arrival;
    }

    public void setArrival(Integer arrival) {
        this.arrival = arrival;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }
}
