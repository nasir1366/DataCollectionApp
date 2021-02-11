package com.example.roomapp.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomapp.model.Station;
import java.util.List;

@Dao
public interface StationDao {
    @Query("SELECT * FROM station_table")
    public LiveData<List<Station>> getAll();

    @Query("SELECT * FROM station_table WHERE name LIKE :name LIMIT 1")
    public LiveData<Station> findByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAll(List<Station> stations);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Station station);

    @Update
    public void updateAll(List<Station> stations);

    @Delete
    public void delete(Station station);

    @Query("DELETE FROM station_table")
    public void deleteAll();

}
