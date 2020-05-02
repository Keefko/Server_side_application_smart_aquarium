package com.smartaquarium.smartaquarium.entity;


import com.smartaquarium.smartaquarium.security.BcryptGenerator;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "login")
    @NonNull
    private String login;

    @Column(name = "password")
    @NonNull
    private String password;

    @Column(name = "email")
    @Nullable
    private String email;

    public User() {
    }

    public User(String login, String password, String email){
        this.login = login;
        BcryptGenerator bcryptGenerator = new BcryptGenerator();
        this.password = bcryptGenerator.passwordEncoder(password);
        //this.password = password;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    @NonNull
    public String getLogin() {
        return login;
    }

    public void setLogin(@NonNull String login) {
        this.login = login;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        BcryptGenerator bcryptGenerator = new BcryptGenerator();
        this.password = bcryptGenerator.passwordEncoder(password);
        //this.password=password;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
