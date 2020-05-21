package com.smartaquarium.smartaquarium.entity;


import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "measurament")
public class Measurament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NonNull
    @Column(name = "aquarium_id")
    private Integer aquariumId;

    @Nullable
    @Column(name = "ph")
    private int ph;

    @Nullable
    @Column(name = "orp")
    private int orp;

    @Nullable
    @Column(name = "temperature")
    private Double temperature;

    @NonNull
    @Column(name = "create_time")
    private Timestamp createTime;

    public Measurament() {
    }


    public Measurament(Integer aquariumId, int ph, int orp , Double temperature, Timestamp createTime) {
        this.aquariumId = aquariumId;
        this.ph = ph;
        this.orp = orp;
        this.temperature = temperature;
        this.createTime = createTime;
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

    @Nullable
    public int getPh() {
        return ph;
    }

    public void setPh(@Nullable int ph) {
        this.ph = ph;
    }

    @Nullable
    public int getOrp() {
        return orp;
    }

    public void setOrp(@Nullable int orp) {
        this.orp = orp;
    }

    @Nullable
    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(@Nullable Double temperature) {
        this.temperature = temperature;
    }

    @NonNull
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(@NonNull Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Measurament{" +
                "id=" + id +
                ", aquariumId=" + aquariumId +
                ", ph=" + ph +
                ", orp=" + orp +
                ", temperature=" + temperature +
                ", createTime=" + createTime +
                '}';
    }
}
