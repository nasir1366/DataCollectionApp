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
import com.example.roomapp.view.adapter.MainRecyclerAdapter;
import com.example.roomapp.model.MainRecyclerModel;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

public class BindingAdapters {

    @BindingAdapter("bind:recyclerdata")
    public static void recyclerViewBinder(final RecyclerView recyclerView
            , final LiveData<List<MainRecyclerModel>> listLiveData){

        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()
                ,LinearLayoutManager.VERTICAL,false));

        listLiveData.observe((LifecycleOwner) recyclerView.getContext(), new Observer<List<MainRecyclerModel>>() {
            @Override
            public void onChanged(List<MainRecyclerModel> mainRecyclerModelList) {
                MainRecyclerAdapter adapter = new MainRecyclerAdapter(listLiveData.getValue());

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
