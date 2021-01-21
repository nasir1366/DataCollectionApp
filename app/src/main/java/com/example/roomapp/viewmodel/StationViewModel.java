package com.example.roomapp.viewmodel;

import android.content.Context;
import android.os.Environment;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.roomapp.App;
import com.example.roomapp.BR;
import com.example.roomapp.R;
import com.example.roomapp.data.AppDatabase;
import com.example.roomapp.data.StationDao;
import com.example.roomapp.model.Station;
import com.example.roomapp.view.adapter.StationAdapter;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;

public class StationViewModel extends BaseObservable {
    private Context context;
    private int stationId;
    private String name;
    private String phoneNumber;
    private long lat,lon;
    private String imageUrl;

    private ArrayList<StationViewModel> stationViewModels;
    private ArrayList<Station> stations;

    public StationViewModel(Station station){
        this.name = station.getName();
        this.phoneNumber = station.getPhoneNumber();
        this.imageUrl = station.getImageUrl();
    }

    public StationViewModel(Context context){
        this.context = context;
        stationViewModels = new ArrayList<>();
        stations = new ArrayList<>();


        for(int i=1;i<25;i++){

            Station station = new Station();
            station.setName("station"+i);
            station.setPhoneNumber("0915443109"+i);
            station.setImageUrl("station"+i);
            stations.add(station);
            StationViewModel stationViewModel = new StationViewModel(station);
            stationViewModels.add(stationViewModel);

        }
//        AppDatabase db = AppDatabase.getDatabase(context);
//        StationDao stationDao = db.stationDao();
//        stationDao.insertAll(stations);
//        Single<List<Station>> singleStations ;
//        singleStations = stationDao.getAll();
//        Disposable disposable = singleStations
//                .subscribeWith(
//                        new DisposableSingleObserver<List<Station>>() {
//
//                            @Override
//                            public void onSuccess(@NonNull List<Station> stations) {
//                                for(int i=0 ; i<stations.size() ; i++){
//                                    stationViewModels.add(new StationViewModel(stations.get(i)));
//                                }
//                            }
//
//                            @Override
//                            public void onError(@NonNull Throwable e) {
//                                e.printStackTrace();
//                            }
//                        }
//                );
//                disposable.dispose();

    }

    @BindingAdapter("bind:recyclerStation")
    public static void recyclerViewBinder(final RecyclerView recyclerView , final ArrayList<StationViewModel> stationViewModels){
        StationAdapter adapter = new StationAdapter(stationViewModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()
                ,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);

    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        String baseurl = Environment.getExternalStorageDirectory().toString()
                + File.separator
                + App.getApplicationName(view.getContext())
                + File.separator
                +imageUrl+
                ".jpg";
        File f = new File(baseurl);
        Picasso.get().load(f).error(R.drawable.error).into(view);

    }


    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public long getLon() {
        return lon;
    }

    public void setLon(long lon) {
        this.lon = lon;
    }

    @Bindable
    public ArrayList<StationViewModel> getStationViewModels() {
        return stationViewModels;
    }

    @Bindable
    public void setStationViewModels(ArrayList<StationViewModel> stationViewModels) {
        this.stationViewModels = stationViewModels;
        notifyPropertyChanged(BR.stationViewModels);
    }

    @Bindable
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String url) {
        this.imageUrl = url;
    }
}
