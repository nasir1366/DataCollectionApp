package com.example.roomapp;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    public static final String API_KEY = "8d167e13c5cf26c8acd7c09eb89e1e0b";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static String getApplicationName(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }
}
