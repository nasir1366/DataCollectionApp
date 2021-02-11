package com.example.roomapp.model;


import java.util.ArrayList;
import java.util.List;

public class DetailRecyclerModel {
    private List<SensorData> sensorDataList;

    public DetailRecyclerModel(List<SensorData> sensorDataList) {

        this.sensorDataList = sensorDataList;
    }

    public List<SensorData> getSensorDataList() {
        return sensorDataList;
    }

    public void setSensorDataList(List<SensorData> sensorDataList) {
        this.sensorDataList = sensorDataList;
    }
}
