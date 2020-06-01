package com.smartaquarium.smartaquarium.entity;



import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name="mqtt")
public class MqttBroker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NonNull
    @Column(name = "aquarium_id")
    private Integer aquariumId;

    @NonNull
    @Column(name = "broker_url")
    private String brokerUrl;

    @NonNull
    @Column(name = "username")
    private String username;

    @NonNull
    @Column(name = "password")
    private String password;

    public MqttBroker() {
    }

    public MqttBroker(Integer aquariumId, String brokerUrl, String username, String password){
        this.aquariumId = aquariumId;
        this.brokerUrl = brokerUrl;
        this.username = username;
        this.password = password;
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
    public String getBrokerUrl() {
        return brokerUrl;
    }

    public void setBrokerUrl(@NonNull String brokerUrl) {
        this.brokerUrl = brokerUrl;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }
}
