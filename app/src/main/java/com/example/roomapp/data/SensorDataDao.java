package com.example.roomapp.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomapp.model.SensorData;

import java.util.List;

@Dao
public interface SensorDataDao {

    @Query("SELECT * FROM sensordata_table")
    public LiveData<List<SensorData>> getAll();

    @Query("SELECT * FROM sensordata_table WHERE stationRelatedId = :id LIMIT 20")
    public LiveData<List<SensorData>> getRelatedData(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAll(List<SensorData> stations);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(SensorData sensorData);

    @Update
    public void updateAll(List<SensorData> stations);

    @Delete
    public void delete(SensorData sensorData);

    @Query("DELETE FROM sensordata_table")
    public void deleteAll();

}
