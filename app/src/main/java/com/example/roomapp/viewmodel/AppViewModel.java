package com.example.roomapp.viewmodel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roomapp.data.AppRepository;
import com.example.roomapp.model.DetailRecyclerModel;
import com.example.roomapp.model.MainRecyclerModel;
import com.example.roomapp.model.SensorData;
import com.example.roomapp.model.Station;
import java.util.List;

public class AppViewModel extends AndroidViewModel {

    private AppRepository appRepository;
    private AppCompatActivity activity ;

    public AppViewModel(@NonNull AppCompatActivity mactivity) {
        super(mactivity.getApplication());
        this.activity = mactivity;
        this.appRepository = new AppRepository(mactivity.getApplication());


//        mRepositoryData.deleteTable();
//        generateStationsSample();
//        generateDataSample();
    }


    public AppCompatActivity getActivity() {
        return this.activity;
    }

    public LiveData<List<MainRecyclerModel>> getMainRecyclerlist() {
        return appRepository.getAllMainRecyclerdata();
    }

    public LiveData<List<Station>> getAllStations() {

        return appRepository.getAllStations();
    }

    public LiveData<List<SensorData>> getAllSensorData() {

        return appRepository.getAllSensorData();
    }

    public LiveData<List<SensorData>> getRelatedSensorData(String stationId) {

        return appRepository.getRelatedSensorData(stationId);
    }

    public void refreshAllData(){
        appRepository.loadAppDataRetrofit();
    }

}
