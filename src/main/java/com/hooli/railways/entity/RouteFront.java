package com.hooli.railways.entity;

public class RouteFront {
    private Integer id;
    private Integer departure;
    private Integer arrival;
    private Integer price;
    private Integer start;
    private Integer end;

    public RouteFront(Integer id, Integer departure, Integer arrival, Integer price, Integer start, Integer end) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
        this.start = start;
        this.end = end;
    }

    public RouteFront() {
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public Integer getArrival() {
        return arrival;
    }

    public void setArrival(Integer arrival) {
        this.arrival = arrival;
    }
}
