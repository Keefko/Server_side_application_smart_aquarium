package com.smartaquarium.smartaquarium.service.handling;

import java.sql.Timestamp;

public class Ph {

    private Integer aquariumId;
    private Timestamp from;
    private Timestamp to;
    private String interval;

    public Ph(Integer aquariumId, Timestamp from, Timestamp to, String interval) {
        this.aquariumId = aquariumId;
        this.from = from;
        this.to = to;
        this.interval = interval;
    }

    public Ph() {
    }

    public Integer getAquariumId() {
        return aquariumId;
    }

    public void setAquariumId(Integer aquariumId) {
        this.aquariumId = aquariumId;
    }

    public Timestamp getFrom() {
        return from;
    }

    public void setFrom(Timestamp from) {
        this.from = from;
    }

    public Timestamp getTo() {
        return to;
    }

    public void setTo(Timestamp to) {
        this.to = to;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }
}
