package com.bachelor.smartaquarium.entity;

import javax.persistence.*;

@Entity
@Table(name = "measurament_data")
public class MeasuramentData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "value")
    private int value;


    public MeasuramentData() {
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
