package com.smartaquarium.smartaquarium.service.handling;

import java.sql.Timestamp;

public class MeasuramentGraphData {

    private int data;
    private Timestamp time;

    public MeasuramentGraphData(int data, Timestamp time) {
        this.data = data;
        this.time = time;
    }

    public MeasuramentGraphData() {}

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
