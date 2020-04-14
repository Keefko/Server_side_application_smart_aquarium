package com.bachelor.smartaquarium.entity;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name = "aquarium_id")
    private int aquariumID;

    public User(String name, String password, String email, int aquariumID) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.aquariumID = aquariumID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAquariumID() {
        return aquariumID;
    }

    public void setAquariumID(int aquariumID) {
        this.aquariumID = aquariumID;
    }
}
