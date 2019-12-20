package com.bachelor.smartaquarium.domain;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Objects;

public class User {
    @Nullable
    public Integer id;
    @NonNull
    private String name;
    @NonNull
    private String password;
    @Nullable
    private Aquarium aquarium;

    public User(String name, String password, Aquarium aquarium){
        this.name= name;
        this.password= password;
        this.aquarium = aquarium;
    }

    @Nullable
    public Integer getId() {
        return id;
    }

    public void setId(@Nullable Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Nullable
    public Aquarium getAquarium() {
        return aquarium;
    }

    public void setAquarium(@Nullable Aquarium aquarium) {
        this.aquarium = aquarium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(password, user.password) &&
                Objects.equals(aquarium, user.aquarium);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, aquarium);
    }
}
