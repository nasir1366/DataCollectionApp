package com.example.roomapp.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roomapp.data.AppRepository;
import com.example.roomapp.data.RepositoryData;
import com.example.roomapp.data.RepositoryStations;
import com.example.roomapp.model.MainRecyclerModel;
import com.example.roomapp.model.SensorData;
import com.example.roomapp.model.Station;

import java.util.ArrayList;
import java.util.List;


public class AppViewModel extends AndroidViewModel {

    private final RepositoryStations mRepositoryStations;
    private final LiveData<List<Station>> mStations;
    private final RepositoryData mRepositoryData;
    private final LiveData<List<SensorData>> mSensorData;
    private final LiveData<List<MainRecyclerModel>> mainRecyclerlist;
    private final AppRepository appRepository;

    public AppViewModel(@NonNull Application application) {
        super(application);
        mRepositoryStations = new RepositoryStations(application);
        mStations = mRepositoryStations.getAllStations();
        mRepositoryData = new RepositoryData(application);
        mSensorData = mRepositoryData.getAllSensorData();
        appRepository = new AppRepository(application);
        mainRecyclerlist = appRepository.getAllMainRecyclerdata();

//        mRepositoryData.deleteTable();
//        generateStationsSample();
//        generateDataSample();
    }

    public LiveData<List<MainRecyclerModel>> getMainRecyclerlist() {
        return mainRecyclerlist;
    }

    public LiveData<List<Station>> getStations() {
        return mStations;
    }

    public LiveData<List<SensorData>> getSensorData() {
        return mSensorData;
    }

    void generateStationsSample(){

        List<Station> stationList = new ArrayList<>();
        for(int i=0 ; i<22 ; i++){
            Station station = new Station();
            station.setName("station" + i);
            station.setStationId("101" + i);
            station.setPhoneNumber("0915443109" + i);
            station.setImageUrl(station.getName());
            stationList.add(station);

        }
        mRepositoryStations.insertList(stationList);
    }

    void generateDataSample(){

        List<SensorData> sensorDataList = new ArrayList<>();
        for(int i=0 ; i<4 ; i++){
            SensorData sensorData = new SensorData();
            sensorData.stationRelatedId = 3L;
            sensorData.setBatteryVoltage(5.11+i);
            sensorData.setInnerTemperature(10+i);
            sensorDataList.add(sensorData);

        }
        for(int i=0 ; i<3 ; i++){
            SensorData sensorData = new SensorData();
            sensorData.stationRelatedId = 5L;
            sensorData.setBatteryVoltage(5.11+i);
            sensorData.setInnerTemperature(10+i);
            sensorDataList.add(sensorData);

        }
        mRepositoryData.insertList(sensorDataList);
    }

}
