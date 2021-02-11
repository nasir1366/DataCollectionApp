package com.example.roomapp.view;

import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.roomapp.R;
import com.example.roomapp.model.DetailRecyclerModel;
import com.example.roomapp.model.SensorData;
import com.example.roomapp.view.adapter.DetailRecyclerAdapter;
import com.example.roomapp.view.adapter.MainRecyclerAdapter;
import com.example.roomapp.model.MainRecyclerModel;
import com.example.roomapp.viewmodel.AppViewModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class BindingAdapters extends BaseObservable {
    public static OkHttpClient okHttpClient;
    public static Picasso picasso;

    @BindingAdapter("bind:recyclerdata")
    public static void recyclerViewBinder(final RecyclerView recyclerView
            , final AppViewModel appViewModel){

        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()
                ,LinearLayoutManager.VERTICAL,false));

        LiveData<List<MainRecyclerModel>> listLiveData = appViewModel.getMainRecyclerlist();

        listLiveData.observe((LifecycleOwner) recyclerView.getContext(), new Observer<List<MainRecyclerModel>>() {
            @Override
            public void onChanged(List<MainRecyclerModel> mainRecyclerModelList) {

                MainRecyclerAdapter adapter = new MainRecyclerAdapter(
                        mainRecyclerModelList
                        ,appViewModel);

                recyclerView.setAdapter(adapter);
            }
        });


    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {

//        String baseurl = Environment.getExternalStorageDirectory().toString()
//                + File.separator
//                + App.getApplicationName(view.getContext())
//                + File.separator
//                +imageUrl+
//                ".jpg";
//        File f = new File(baseurl);
        if(okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder()
                    .authenticator(new Authenticator() {
                        @Override
                        public Request authenticate(Route route, Response response) throws IOException {
                            String credential = Credentials.basic("frb148218", "13vMKA5bGXyt3L");
                            return response.request().newBuilder()
                                    .header("Authorization", credential)
                                    .build();
                        }
                    })
                    .build();
        }
        if(picasso == null) {
            picasso = new Picasso.Builder(view.getContext())
                    .downloader(new OkHttp3Downloader(okHttpClient))
                    .build();
        }

        picasso.load(imageUrl)
                .placeholder(R.drawable.station)
                .resize(64,64)
                .centerCrop()
                .error(R.drawable.error)
                .into(view, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.i("picasso","picasso load seccessfully");
                    }

                    @Override
                    public void onError(Exception e) {
                        Log.i("picasso",e.getMessage());
                    }
                });

    }


    @BindingAdapter("bind:detailrecycle")
    public static void detailRecyclerBinder(final RecyclerView recyclerView
    ,@NonNull final List<SensorData> sensorDataList
    )
    {
        if(!sensorDataList.isEmpty()) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()
                    , LinearLayoutManager.VERTICAL, false));
            DetailRecyclerAdapter adapter = new DetailRecyclerAdapter(sensorDataList);
            recyclerView.setAdapter(adapter);
        }
    }


}
