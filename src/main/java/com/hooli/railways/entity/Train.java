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
}
