package com.example.roomapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.room.Room;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.roomapp.R;
import com.example.roomapp.data.AppDatabase;
import com.example.roomapp.data.StationDao;
import com.example.roomapp.databinding.ActivityMainBinding;
import com.example.roomapp.model.Station;
import com.example.roomapp.viewmodel.StationViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StationViewModel stationViewModel = new StationViewModel(this);

        ActivityMainBinding activityMainBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);

        activityMainBinding.setStation(stationViewModel);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(getResources().getString(R.string.about)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                return false;
            }
        });
        menu.add(getResources().getString(R.string.add_station)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}