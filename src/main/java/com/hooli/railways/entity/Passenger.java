package com.hooli.railways.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PASSENGER")
public class Passenger{
    @Id
    @Column(name = "STATE_ID")
    private Integer stateId;
    @Column(name = "FNAME")
    private String firstName;
    @Column(name = "LNAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "ID")
    private Integer id;

    public Passenger(Integer stateId, String firstName, String lastName, String email, String phone, Integer id) {
        this.stateId = stateId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Passenger() {

    }


    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
