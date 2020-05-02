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
    @Column(name = "min_ph")
    private int minPh;

    @NonNull
    @Column(name = "min_orp")
    private int minOrp;

    @NonNull
    @Column(name = "min_temperature")
    private Double minTemperature;

    @NonNull
    @Column(name = "max_ph")
    private int maxPh;

    @NonNull
    @Column(name = "max_orp")
    private int maxOrp;

    @NonNull
    @Column(name = "max_temperature")
    private Double maxTemperature;

    @NonNull
    @Column(name = "aquarium_id")
    private Integer aquariumId;

    @NonNull
    @Column(name = "user_id")
    private Integer userId;

    public AquariumSettings() {
    }

    public AquariumSettings(int minPh, int minOrp, Double minTemperature, int maxPh, int maxOrp, Double maxTemperature, Integer aquariumId, Integer userId) {
        this.minPh = minPh;
        this.minOrp = minOrp;
        this.minTemperature = minTemperature;
        this.maxPh = maxPh;
        this.maxOrp = maxOrp;
        this.maxTemperature = maxTemperature;
        this.aquariumId = aquariumId;
        this.userId = userId;
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

    public int getMinPh() {
        return minPh;
    }

    public void setMinPh(int minPh) {
        this.minPh = minPh;
    }

    public int getMinOrp() {
        return minOrp;
    }

    public void setMinOrp(int minOrp) {
        this.minOrp = minOrp;
    }

    @NonNull
    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(@NonNull Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public int getMaxPh() {
        return maxPh;
    }

    public void setMaxPh(int maxPh) {
        this.maxPh = maxPh;
    }

    public int getMaxOrp() {
        return maxOrp;
    }

    public void setMaxOrp(int maxOrp) {
        this.maxOrp = maxOrp;
    }

    @NonNull
    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(@NonNull Double maxTemperature) {
        this.maxTemperature = maxTemperature;
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

    @NonNull
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(@NonNull Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "AquariumSettings{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", minPh=" + minPh +
                ", minOrp=" + minOrp +
                ", minTemperature=" + minTemperature +
                ", maxPh=" + maxPh +
                ", maxOrp=" + maxOrp +
                ", maxTemperature=" + maxTemperature +
                ", aquariumId=" + aquariumId +
                ", userId=" + userId +
                '}';
    }
}
