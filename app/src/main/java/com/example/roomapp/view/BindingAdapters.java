package com.example.roomapp.view;

import android.os.Environment;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomapp.App;
import com.example.roomapp.R;
import com.example.roomapp.model.Station;
import com.example.roomapp.view.adapter.StationAdapter;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

public class BindingAdapters {

    @BindingAdapter("bind:recyclerStation")
    public static void recyclerViewBinder(final RecyclerView recyclerView , final LiveData<List<Station>> listLiveData){

        listLiveData.observe((LifecycleOwner) recyclerView.getContext(), new Observer<List<Station>>() {
            @Override
            public void onChanged(List<Station> stations) {
                StationAdapter adapter = new StationAdapter(listLiveData.getValue());
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()
                ,LinearLayoutManager.VERTICAL,false));
                recyclerView.setAdapter(adapter);
            }
        });


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
}
