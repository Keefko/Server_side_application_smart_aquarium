package com.bachelor.smartaquarium.entity;

import javax.persistence.*;

@Entity
@Table(name = "measurament_type")
public class MeasuramentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "type")
    private String type;

    public MeasuramentType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }
}
