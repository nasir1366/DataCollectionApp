package com.example.roomapp.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomapp.model.Station;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface StationDao {
    @Query("SELECT * FROM station")
    public Flowable<List<Station>> getAll();

    @Query("SELECT * FROM station WHERE id IN (:stationIds)")
    public Flowable<List<Station>> loadAllByIds(int[] stationIds);

    @Query("SELECT * FROM station WHERE name LIKE :name LIMIT 1")
    public Flowable<Station> findByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public Completable insertAll(ArrayList<Station> stations);

    @Update
    public Completable updateAll(ArrayList<Station> stations);

    @Delete
    public Completable delete(Station station);

}
