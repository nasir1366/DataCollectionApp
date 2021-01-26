package com.example.roomapp.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.roomapp.model.MainRecyclerModel;
import com.example.roomapp.model.Station;

import java.util.List;

@Dao
public interface AppDao {

    @Transaction
    @Query("SELECT * FROM station_table")
    public LiveData<List<MainRecyclerModel>> getAllMainRecyclerdata();

}
