package com.hooli.railways.entity;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name="USERNAME")
    private String username;
    @Column(name="PASSWORD")
    private String password;
    @Column(name="EMAIL")
    private String email;

    public User() {

    }

    public User(String username, String password, String email, Integer id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
