package com.example.roomapp.data;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.roomapp.Network.WebService;
import com.example.roomapp.model.DetailRecyclerModel;
import com.example.roomapp.model.MainRecyclerModel;
import com.example.roomapp.model.SensorData;
import com.example.roomapp.model.Station;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppRepository {
    private final AppDao appDao;
    private final WebService webService;
    private final SensorDataDao sensorDataDao;
    private final StationDao stationDao;

    public AppRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        appDao = db.appDao();
        sensorDataDao = db.sensorDataDao();
        stationDao = db.stationDao();
        webService = new WebService(application.getApplicationContext());
    }

    public LiveData<List<Station>> getAllStations(){
        LiveData<List<Station>> stations = new MutableLiveData<List<Station>>();
        stations = stationDao.getAll();
        return stations;
    }

    public LiveData<List<SensorData>> getAllSensorData(){
        LiveData<List<SensorData>> listLiveData = new MutableLiveData<List<SensorData>>();
        listLiveData = sensorDataDao.getAll();
        return listLiveData;
    }

    public LiveData<List<SensorData>> getRelatedSensorData(String stationId){
        LiveData<List<SensorData>> listLiveData = new MutableLiveData<List<SensorData>>();
        listLiveData = sensorDataDao.getRelatedData(stationId);
        return listLiveData;
    }

    public LiveData<List<MainRecyclerModel>> getAllMainRecyclerdata(){
        LiveData<List<MainRecyclerModel>> listLiveData = new MutableLiveData<List<MainRecyclerModel>>();
        listLiveData = appDao.getAllMainRecyclerdata();

        return listLiveData;
    }


    public void insertStation(Station station){
        AppDatabase.databaseWriteExecutor.execute(
                () -> stationDao.insert(station)
        );
    }

    public void insertAllStations(List<Station> stationList){
        AppDatabase.databaseWriteExecutor.execute(
                () -> stationDao.insertAll(stationList)
        );
    }

    public void insertSensorData(SensorData sensorData){
        AppDatabase.databaseWriteExecutor.execute(
                () -> sensorDataDao.insert(sensorData)
        );
    }

    public void insertAllSensorData(List<SensorData> sensorDataList){
        AppDatabase.databaseWriteExecutor.execute(
                () -> sensorDataDao.insertAll(sensorDataList)
        );
    }

    public void loadAppDataRetrofit(){
        String url = null;
        url = webService.prepareUrl("getAllStations");
        Log.i("retrofit","urlStation:"+url);
        Call<List<Station>> allStations = webService.getAPIService().getAllStations(url);

        url = webService.prepareUrl("getAllSensorData");
        Log.i("retrofit","urlSensorData:"+url);
        Call<List<SensorData>> allSensorData = webService.getAPIService().getAllSensorData(url);

        allStations.enqueue(new Callback<List<Station>>() {
            @Override
            public void onResponse(Call<List<Station>> call, retrofit2.Response<List<Station>> response) {

                if(response.isSuccessful()){
                    insertAllStations(response.body());
                }
                else{
                    try {
                        Log.i("retrofit" , response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Station>> call, Throwable t) {
                Log.i("retrofit" , t.getMessage());

            }
        });

        allSensorData.enqueue(new Callback<List<SensorData>>() {
            @Override
            public void onResponse(Call<List<SensorData>> call, Response<List<SensorData>> response) {
                if(response.isSuccessful()){
                    insertAllSensorData(response.body());
                }
                else{
                    try {
                        Log.i("retrofit" , response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<SensorData>> call, Throwable t) {
                Log.i("retrofit" , t.getMessage());
            }
        });

    }


}
