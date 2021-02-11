package com.example.roomapp.data;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomapp.model.SensorData;
import com.example.roomapp.model.Station;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Station.class , SensorData.class}, version = 1 , exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract StationDao stationDao();
    public abstract SensorDataDao sensorDataDao();
    public abstract AppDao appDao();

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "db_station")
                            .build();

                }
            }
        }
        return INSTANCE;
    }



}
