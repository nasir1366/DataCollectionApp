package com.example.roomapp.data;

import android.app.Application;

import com.example.roomapp.model.Station;

import java.util.ArrayList;
import java.util.List;

import kotlinx.coroutines.flow.Flow;

public class Repository {
    private StationDao dao;
    private ArrayList<Station> stations;


    Repository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        dao = db.stationDao();

    }

    public List<Station>  getAllStations(){

        return stations;
    }


}
