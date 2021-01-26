package com.example.roomapp.data;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.roomapp.data.AppDatabase;
import com.example.roomapp.data.SensorDataDao;
import com.example.roomapp.data.StationDao;
import com.example.roomapp.model.SensorData;
import com.example.roomapp.model.Station;
import java.util.List;

public class RepositoryStations {
    private final StationDao stationDao;


    public RepositoryStations(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        stationDao = db.stationDao();

    }

    public LiveData<List<Station>> getAllStations(){
        LiveData<List<Station>> stations = new MutableLiveData<List<Station>>();
        stations = stationDao.getAll();
        return stations;
    }


    public void insert(Station station){
        AppDatabase.databaseWriteExecutor.execute(
                () -> stationDao.insert(station)
        );
    }

    public void insertList(List<Station> stationList){
        AppDatabase.databaseWriteExecutor.execute(
                () -> stationDao.insertAll(stationList)
        );
    }

    public void deleteTable(){
        AppDatabase.databaseWriteExecutor.execute(
                stationDao::deleteAll
        );
    }



}
