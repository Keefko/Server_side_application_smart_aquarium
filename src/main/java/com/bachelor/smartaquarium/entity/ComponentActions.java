package com.bachelor.smartaquarium.entity;


import javax.persistence.*;

@Entity
@Table(name = "component_actions")
public class ComponentActions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "component_id")
    private int componentId;

    @Column (name = "title")
    private String title;

    @Column(name = "period_allowed")
    private boolean periodAllowed;

    @Column(name = "period")
    private int period;

    public ComponentActions() {
    }

    public int getId() {
        return id;
    }

    public int getComponentId() {
        return componentId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isPeriodAllowed() {
        return periodAllowed;
    }

    public int getPeriod() {
        return period;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setComponentId(int componentId) {
        this.componentId = componentId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPeriodAllowed(boolean periodAllowed) {
        this.periodAllowed = periodAllowed;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
