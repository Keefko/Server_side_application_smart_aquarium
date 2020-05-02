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
    private String name;

    @Column(name = "period_allowed")
    private Boolean periodAllowed;

    @Column(name = "period")
    private Timestamp period;


    public Component() {
    }

    public Component(String name, Boolean periodAllowed, Timestamp period){
        this.name = name;
        this.periodAllowed = periodAllowed;
        this.period = period;
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
