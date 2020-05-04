package com.smartaquarium.smartaquarium.entity;


import org.springframework.lang.NonNull;
import javax.persistence.*;

@Entity
@Table(name = "aquarium_settings")
public class AquariumSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "ph")
    private int ph;

    @NonNull
    @Column(name = "orp")
    private int orp;

    @NonNull
    @Column(name = "temperature")
    private Double temperature;

    @NonNull
    @Column(name = "aquarium_id")
    private Integer aquariumId;

    public AquariumSettings() {
    }

    public AquariumSettings(int ph, int orp, Double temperature,Integer aquariumId) {
        this.ph = ph;
        this.orp = orp;
        this.temperature = temperature;
        this.aquariumId = aquariumId;

    }

    public Integer getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public int getPh() {
        return ph;
    }

    public void setPh(@NonNull int ph) {
        this.ph = ph;
    }

    @NonNull
    public int getOrp() {
        return orp;
    }

    public void setOrp(@NonNull int orp) {
        this.orp = orp;
    }

    @NonNull
    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(@NonNull Double temperature) {
        this.temperature = temperature;
    }

    @NonNull
    public Integer getAquariumId() {
        return aquariumId;
    }

    public void setAquariumId(@NonNull Integer aquariumId) {
        this.aquariumId = aquariumId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AquariumSettings{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ph=" + ph +
                ", orp=" + orp +
                ", temperature=" + temperature +
                ", aquariumId=" + aquariumId +
                '}';
    }
}
