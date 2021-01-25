package com.example.roomapp.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.roomapp.data.Repository;
import com.example.roomapp.model.Station;

import java.util.ArrayList;
import java.util.List;


public class StationViewModel extends AndroidViewModel {
    private final Repository mRepository;
    private final LiveData<List<Station>> mStations;

    public StationViewModel(@NonNull Application application) {
        super(application);
        mRepository = new Repository(application);
        mStations = mRepository.getAllStations();
//        generateData();
    }

    public LiveData<List<Station>> getStations() {
        return mStations;
    }

    void insert(Station station) {
        mRepository.insert(station);
    }

    void generateData(){
        List<Station> stationList = new ArrayList<>();
//        mRepository.deleteTable();
        for(int i=0 ; i<22 ; i++){
            Station station = new Station();
            station.setName("station" + i);
            station.setStationId("101" + i);
            station.setPhoneNumber("0915443109" + i);
            station.setImageUrl(station.getName());
            stationList.add(station);

        }
        mRepository.insertList(stationList);
    }

}
