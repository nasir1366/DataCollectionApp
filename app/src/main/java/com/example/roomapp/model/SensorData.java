package com.example.roomapp.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "sensordata_table")
public class SensorData {

    @PrimaryKey(autoGenerate = true)
    public Integer dataId;

    public Long stationRelatedId;

    private Integer innerTemperature=0,outerTemperature=0;
    private Double rainLevel=0.0,logRainLevel=0.0;
    private Integer waterLevel=0;
    private Byte stateDoor=0;
    private Double batteryVoltage=0.0,solarVoltage=0.0;
    private Integer barometricPressure=0,windDirection=0;
    private Double windSpeed=0.0;
    private Integer simCharge=0; //rial




    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public Integer getInnerTemperature() {
        return innerTemperature;
    }

    public void setInnerTemperature(Integer innerTemperature) {
        this.innerTemperature = innerTemperature;
    }

    public Integer getOuterTemperature() {
        return outerTemperature;
    }

    public void setOuterTemperature(Integer outerTemperature) {
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

    public Integer getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(Integer waterLevel) {
        this.waterLevel = waterLevel;
    }

    public Byte getStateDoor() {
        return stateDoor;
    }

    public void setStateDoor(Byte stateDoor) {
        this.stateDoor = stateDoor;
    }

    public Double getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(Double batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    public Double getSolarVoltage() {
        return solarVoltage;
    }

    public void setSolarVoltage(Double solarVoltage) {
        this.solarVoltage = solarVoltage;
    }

    public Integer getBarometricPressure() {
        return barometricPressure;
    }

    public void setBarometricPressure(Integer barometricPressure) {
        this.barometricPressure = barometricPressure;
    }

    public Integer getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Integer windDirection) {
        this.windDirection = windDirection;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getSimCharge() {
        return simCharge;
    }

    public void setSimCharge(Integer simCharge) {
        this.simCharge = simCharge;
    }
}
