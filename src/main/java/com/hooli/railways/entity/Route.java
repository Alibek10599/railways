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
    @Column(name="NUMBER_OF_TICKETS")
    private Integer numberOfTickets;
    @Column(name="STATIONS")
    private Integer stations;
}
