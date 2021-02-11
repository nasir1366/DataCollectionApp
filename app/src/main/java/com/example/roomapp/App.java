package com.example.roomapp;

import android.app.Application;
import android.content.Context;

import java.io.File;

public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

    }

    public static String getApplicationName(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }
}
