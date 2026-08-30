package com.parcial.model;

public class Measurement {

    private int id;
    private long timestamp;
    private double value;
    private int deviceId;

    public Measurement(int id, long timestamp, double value, int deviceId) {
        this.id = id;
        this.timestamp = timestamp;
        this.value = value;
        this.deviceId = deviceId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

}
