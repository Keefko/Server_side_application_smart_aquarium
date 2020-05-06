package com.smartaquarium.smartaquarium.entity;


import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.PreparedStatement;

@Entity
@Table(name = "connection")
public class Connection {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NonNull
    @Column(name = "aquarium_id")
    private Integer aquariumId;

    @Column(name = "ph_senzor")
    private Boolean phSenzor;

    @Column(name = "orp_senzor")
    private Boolean orpSenzor;

    @Column(name = "thermometer")
    private Boolean thermometer;

    @Column(name = "filtration")
    private Boolean filtration;

    @Column(name = "feeding")
    private Boolean feeding;

    @Column(name = "light")
    private Boolean light;

    public Connection() {
    }

    public Connection(Integer aquariumId,Boolean phSenzor, Boolean orpSenzor, Boolean thermometer,Boolean filtration, Boolean feeding, Boolean light) {
        this.aquariumId = aquariumId;
        this.phSenzor = phSenzor;
        this.orpSenzor = orpSenzor;
        this.thermometer = thermometer;
        this.filtration = filtration;
        this.feeding = feeding;
        this.light = light;
    }

    public Integer getId() {
        return id;
    }

    @NonNull
    public Integer getAquariumId() {
        return aquariumId;
    }

    public void setAquariumId(@NonNull Integer aquariumId) {
        this.aquariumId = aquariumId;
    }

    public Boolean getPhSenzor() {
        return phSenzor;
    }

    public void setPhSenzor(Boolean phSenzor) {
        this.phSenzor = phSenzor;
    }

    public Boolean getOrpSenzor() {
        return orpSenzor;
    }

    public void setOrpSenzor(Boolean orpSenzor) {
        this.orpSenzor = orpSenzor;
    }

    public Boolean getThermometer() {
        return thermometer;
    }

    public void setThermometer(Boolean thermometer) {
        this.thermometer = thermometer;
    }

    public Boolean getFiltration() {
        return filtration;
    }

    public void setFiltration(Boolean filtration) {
        this.filtration = filtration;
    }

    public Boolean getFeeding() {
        return feeding;
    }

    public void setFeeding(Boolean feeding) {
        this.feeding = feeding;
    }

    public Boolean getLight() {
        return light;
    }

    public void setLight(Boolean light) {
        this.light = light;
    }

}
