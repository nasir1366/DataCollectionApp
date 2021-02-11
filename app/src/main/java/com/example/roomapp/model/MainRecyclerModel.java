package com.example.roomapp.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.ArrayList;
import java.util.List;


public class MainRecyclerModel {

    @Embedded public Station station;
    @Relation(
            parentColumn = "stationId",
            entityColumn = "stationRelatedId"
    )
    public List<SensorData> listSensorData;

}
