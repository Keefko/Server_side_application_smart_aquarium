package com.bachelor.smartaquarium.entity;


import javax.persistence.*;

@Entity
@Table(name = "aquarium_type")
public class AquariumType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int Id;

    @Column(name = "type")
    private String type;


    public AquariumType() {
    }

    public int getId() {
        return Id;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setType(String type) {
        this.type = type;
    }
}
