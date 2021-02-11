package com.example.roomapp.data;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.roomapp.model.SensorData;

import java.util.List;

public class RepositoryData {

    private final SensorDataDao sensorDataDao;

    public RepositoryData(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        sensorDataDao = db.sensorDataDao();
    }

    public LiveData<List<SensorData>> getAllSensorData(){
        LiveData<List<SensorData>> listLiveData = new MutableLiveData<List<SensorData>>();
        listLiveData = sensorDataDao.getAll();
        return listLiveData;
    }

    public void insert(SensorData sensorData){
        AppDatabase.databaseWriteExecutor.execute(
                () -> sensorDataDao.insert(sensorData)
        );
    }

    public void insertList(List<SensorData> sensorDataList){
        AppDatabase.databaseWriteExecutor.execute(
                () -> sensorDataDao.insertAll(sensorDataList)
        );
    }

    public void deleteTable(){
        AppDatabase.databaseWriteExecutor.execute(
                sensorDataDao::deleteAll
        );
    }

}
