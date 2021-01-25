package com.example.roomapp.data;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.roomapp.model.Station;
import java.util.List;

public class Repository {
    private final StationDao dao;


    public Repository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        dao = db.stationDao();

    }

    public LiveData<List<Station>> getAllStations(){
        LiveData<List<Station>> stations = new MutableLiveData<List<Station>>();
        stations = dao.getAll();
        return stations;
    }

    public void insert(Station station){
        AppDatabase.databaseWriteExecutor.execute(
                () -> dao.insert(station)
        );
    }

    public void insertList(List<Station> stationList){
        AppDatabase.databaseWriteExecutor.execute(
                () -> dao.insertAll(stationList)
        );
    }

    public void deleteTable(){
        AppDatabase.databaseWriteExecutor.execute(
                dao::deleteAll
        );
    }



}
