package com.bachelor.smartaquarium.entity;
import javax.persistence.*;

@Entity
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private  int id;

    @Column(name = "aquarium_id")
    private int aquariumId;

    @Column(name = "action_id")
    private int actionId;

    @Column(name = "name")
    private String name;

    public Component(int aquariumId, int actionId, String name) {
        this.aquariumId = aquariumId;
        this.actionId = actionId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getAquariumId() {
        return aquariumId;
    }

    public int getActionId() {
        return actionId;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAquariumId(int aquariumId) {
        this.aquariumId = aquariumId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
