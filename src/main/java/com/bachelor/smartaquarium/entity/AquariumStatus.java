package com.bachelor.smartaquarium.entity;


import javax.persistence.*;

@Entity
@Table(name = "aquarium_status")
public class AquariumStatus {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "status")
    private String status;

    public AquariumStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
