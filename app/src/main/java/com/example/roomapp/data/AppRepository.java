package com.example.roomapp.data;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.roomapp.model.MainRecyclerModel;
import com.example.roomapp.model.Station;

import java.util.List;

public class AppRepository {
    private final AppDao appDao;

    public AppRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        appDao = db.appDao();
    }

    public LiveData<List<MainRecyclerModel>> getAllMainRecyclerdata(){
        LiveData<List<MainRecyclerModel>> listLiveData = new MutableLiveData<List<MainRecyclerModel>>();
        listLiveData = appDao.getAllMainRecyclerdata();
        return listLiveData;
    }
}
