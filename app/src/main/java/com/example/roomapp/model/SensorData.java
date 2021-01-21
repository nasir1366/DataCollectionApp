package com.example.roomapp.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public abstract class SensorData {
    @PrimaryKey
    private int dataId;

    private int innerTemperature,outerTemperature;
    private Double rainLevel,logRainLevel;
    private int waterLevel;
    private byte stateDoor;
    private float batteryVoltage,solarVoltage;
    private int barometricPressure,windDirection;
    private float windSpeed;
    private int simCharge; //rial

    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public int getInnerTemperature() {
        return innerTemperature;
    }

    public void setInnerTemperature(int innerTemperature) {
        this.innerTemperature = innerTemperature;
    }

    public int getOuterTemperature() {
        return outerTemperature;
    }

    public void setOuterTemperature(int outerTemperature) {
        this.outerTemperature = outerTemperature;
    }

    public Double getRainLevel() {
        return rainLevel;
    }

    public void setRainLevel(Double rainLevel) {
        this.rainLevel = rainLevel;
    }

    public Double getLogRainLevel() {
        return logRainLevel;
    }

    public void setLogRainLevel(Double logRainLevel) {
        this.logRainLevel = logRainLevel;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(int waterLevel) {
        this.waterLevel = waterLevel;
    }

    public byte getStateDoor() {
        return stateDoor;
    }

    public void setStateDoor(byte stateDoor) {
        this.stateDoor = stateDoor;
    }

    public float getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(float batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    public float getSolarVoltage() {
        return solarVoltage;
    }

    public void setSolarVoltage(float solarVoltage) {
        this.solarVoltage = solarVoltage;
    }

    public int getBarometricPressure() {
        return barometricPressure;
    }

    public void setBarometricPressure(int barometricPressure) {
        this.barometricPressure = barometricPressure;
    }

    public int getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(int windDirection) {
        this.windDirection = windDirection;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getSimCharge() {
        return simCharge;
    }

    public void setSimCharge(int simCharge) {
        this.simCharge = simCharge;
    }
}
