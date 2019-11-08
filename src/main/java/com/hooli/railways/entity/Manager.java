package com.hooli.railways.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MANAGER")
public class Manager {
    @Id
    @Column(name = "USERNAME")
    private String username;
    @Column(name="PASSWORD")
    private String password;

    public Manager(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Manager(){ }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
