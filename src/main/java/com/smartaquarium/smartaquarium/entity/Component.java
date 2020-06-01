package com.smartaquarium.smartaquarium.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table (name="component")
public class Component {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NonNull
    @Column(name = "aquarium_id")
    private Integer aquariumId;

    @NonNull
    @Column(name ="name")
    private String name;

    @NonNull
    @Column(name ="topic")
    private String topic;

    @Column(name = "period_allowed")
    private Boolean periodAllowed;

    @Column(name = "period")
    private Timestamp period;

    @Column(name = "turn_on")
    private Boolean turnOn;

    @Column(name = "cyklus")
    private int cyklus;

    public Component() {
    }

    public Component(Integer aquariumId,String name,String topic, Boolean periodAllowed, Timestamp period, Boolean turnOn, int cyklus){
        this.aquariumId = aquariumId;
        this.name = name;
        this.topic = topic;
        this.periodAllowed = periodAllowed;
        this.period = period;
        this.turnOn = turnOn;
        this.cyklus = cyklus;
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

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public Boolean getPeriodAllowed() {
        return periodAllowed;
    }

    public void setPeriodAllowed(Boolean periodAllowed) {
        this.periodAllowed = periodAllowed;
    }

    public Timestamp getPeriod() {
        return period;
    }

    public void setPeriod(Timestamp period) {
        this.period = period;
    }


    public Boolean getTurnOn() {
        return turnOn;
    }

    public void setTurnOn(Boolean turnOn) {
        this.turnOn = turnOn;
    }

    public int getCyklus() {
        return cyklus;
    }

    public void setCyklus(int cyklus) {
        this.cyklus = cyklus;
    }

    @NonNull
    public String getTopic() {
        return topic;
    }

    public void setTopic(@NonNull String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Component{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", periodAllowed=" + periodAllowed +
                ", period=" + period +
                '}';
    }
}
