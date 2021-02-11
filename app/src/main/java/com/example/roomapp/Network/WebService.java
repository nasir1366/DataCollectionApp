package com.example.roomapp.Network;

import android.content.Context;

import com.example.roomapp.model.SensorData;
import com.example.roomapp.model.Station;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class WebService {

    public static final String API_KEY = "8d167e13c5cf26c8acd7c09eb89e1e0b";
    private static final String BASE_URL = "http://nasirbagheri.freecloudsite.com/";
    private ServiceAPI serviceAPI;
    private Context context;

    public WebService(Context context){
        this.context = context;

    }

    public String prepareUrl(String cmd){
        String url = null;
        if("getAllStations".equals(cmd)){
            url = "?cmd=getAllStations";
        }
        else if("getAllSensorData".equals(cmd)){
            url = "?cmd=getAllSensorData";
        }
        return url;
    }

    public interface ServiceAPI{

        @GET()
        Call<List<Station>> getAllStations(@Url String url);

        @GET()
        Call<List<SensorData>> getAllSensorData(@Url String url);

        @GET()
        Call<SensorData> getSingleData(@Url String url);

    }



    public ServiceAPI getAPIService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(
                        GsonConverterFactory.create(
                                new GsonBuilder().setLenient().create()
                        )
                )
                .build();

        serviceAPI = retrofit.create(ServiceAPI.class);

        return serviceAPI;
    }




}
