package com.example.roomapp.data;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.roomapp.model.Station;
import java.util.List;

public class RepositoryStations {
    private final StationDao stationDao;
    private static RepositoryStations instanse = null;

    public RepositoryStations(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        stationDao = db.stationDao();

    }

    public static RepositoryStations getInstanse(Application application){
        if(instanse == null){
            instanse = new RepositoryStations(application);
        }
        return instanse;
    }

    public static RepositoryStations getInstanse(){

        return instanse;
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
