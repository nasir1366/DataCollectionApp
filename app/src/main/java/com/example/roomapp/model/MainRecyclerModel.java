package com.example.roomapp.model;


import androidx.room.Embedded;
import androidx.room.Relation;


public class MainRecyclerModel {

    @Embedded public Station station;
    @Relation(
            parentColumn = "id",
            entityColumn = "stationRelatedId"
    )
    public SensorData sensorData;

}
