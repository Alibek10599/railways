package com.hooli.railways.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TICKET")
public class Ticket {
    @Id
    @Column(name="ID")
    private Integer id;
    @Column(name="PASSENGER_ID")
    private Integer passengerId;
    @Column(name="PRICE")
    private Integer price;
    @Column(name="START")
    private Integer start;
    @Column(name="END")
    private Integer end;
    @Column(name="SEAT")
    private Integer seat;
    @Column(name="TRAIN_ID")
    private Integer trainId;


    public Ticket(){

    }

    public Ticket(Integer id, Integer passengerId, Integer price, Integer start, Integer end, Integer seat, Integer trainId) {
        this.id = id;
        this.passengerId = passengerId;
        this.price = price;
        this.start = start;
        this.end = end;
        this.seat = seat;
        this.trainId = trainId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
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

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }
}
