package com.parcial.model;

public class Device {

    private int id;
    private String name;
    private String serialNumber;
    private String type;
    private double maxValue;
    private double minValue;
    private long samplingPeriod;
    private long timeTolerance;
    private String unit;

    public Device(int id, String name, String serialNumber, String type, double maxValue, double minValue,
            long samplingPeriod, long timeTolerance, String unit) {

        this.id = id;
        this.name = name;
        this.serialNumber = serialNumber;
        this.type = type;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.samplingPeriod = samplingPeriod;
        this.timeTolerance = timeTolerance;
        this.unit = unit;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public Long getSamplingPeriod() {
        return samplingPeriod;
    }

    public void setSamplingPeriod(Long samplingPeriod) {
        this.samplingPeriod = samplingPeriod;
    }

    public Long getTimeTolerance() {
        return timeTolerance;
    }

    public void setTimeTolerance(Long timeTolerance) {
        this.timeTolerance = timeTolerance;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}