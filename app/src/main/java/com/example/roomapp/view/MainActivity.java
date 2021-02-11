package com.example.roomapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.example.roomapp.R;
import com.example.roomapp.databinding.ActivityMainBinding;
import com.example.roomapp.model.SensorData;
import com.example.roomapp.viewmodel.AppViewModel;

import java.util.List;


public class MainActivity extends AppCompatActivity {
public AppViewModel appViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        FileOperation.FileExecutor.execute(
//                () -> FileOperation.copyFile(this, App.getApplicationName(this),"")
//        );

        appViewModel = new AppViewModel(this);

        ActivityMainBinding activityMainBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);

        activityMainBinding.setMainrecycledata(appViewModel);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menuItem;
        menuItem = menu.add("loadFromNet").setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_ALWAYS);
        menuItem.setIcon(R.drawable.refresh_ic);
        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
//                appViewModel.getRelatedSensorData("1011").observe(MainActivity.this, new Observer<List<SensorData>>() {
//                    @Override
//                    public void onChanged(List<SensorData> sensorDataList) {
//                        msensorDataList = sensorDataList;
//                    }
//                });
                appViewModel.refreshAllData();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }


}