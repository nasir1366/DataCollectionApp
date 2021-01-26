package com.example.roomapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.roomapp.App;
import com.example.roomapp.R;
import com.example.roomapp.data.FileOperation;
import com.example.roomapp.databinding.ActivityMainBinding;
import com.example.roomapp.viewmodel.AppViewModel;


public class MainActivity extends AppCompatActivity {
private AppViewModel appViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        FileOperation.FileExecutor.execute(
//                () -> FileOperation.copyFile(this, App.getApplicationName(this),"")
//        );


        appViewModel = new AppViewModel(this.getApplication());

        ActivityMainBinding activityMainBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);

        activityMainBinding.setMainrecycledata(appViewModel);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(getResources().getString(R.string.about)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }
}