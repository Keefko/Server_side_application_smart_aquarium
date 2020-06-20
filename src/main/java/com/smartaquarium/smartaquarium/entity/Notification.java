package com.smartaquarium.smartaquarium.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name="notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NonNull
    @Column(name = "aquarium_id")
    private Integer aquariumId;

    @NonNull
    @Column(name = "property")
    private String property;

    @NonNull
    @Column(name = "text")
    private String text;

    @Column(name = "visible")
    private Boolean visible;

    @NonNull
    @Column(name = "name")
    private String name;

    public Notification() {
    }

    public Notification(Integer aquariumId, String property, String text,Boolean visible, String name) {
        this.aquariumId = aquariumId;
        this.property = property;
        this.text = text;
        this.visible = visible;
        this.name = name;
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
    public String getProperty() {
        return property;
    }

    public void setProperty(@NonNull String property) {
        this.property = property;
    }

    @NonNull
    public String getText() {
        return text;
    }

    public void setText(@NonNull String text) {
        this.text = text;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }
}
