package com.smartaquarium.smartaquarium.entity;

import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aquarium")
public class Aquarium {

    @Id
    @NonNull
    @Column(name = "aquarium_id")
    private Integer id;

    @NonNull
    @Column(name = "user_id")
    private Integer userId;

    @NonNull
    @Column(name = "name")
    private String name;

    @Column(name = "warning")
    private Boolean warning;

    public Aquarium() {
    }

    public Aquarium(Integer id, Integer userId, String name, Boolean warning) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.warning = warning;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(@NonNull Integer userId) {
        this.userId = userId;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public Boolean getWarning() {
        return warning;
    }

    public void setWarning(Boolean warning) {
        this.warning = warning;
    }

    @Override
    public String toString() {
        return "Aquarium{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", warning=" + warning +
                '}';
    }
}
