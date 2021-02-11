package com.example.roomapp.view.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.example.roomapp.R;
import com.example.roomapp.databinding.ItemRecyclerBinding;
import com.example.roomapp.model.MainRecyclerModel;
import com.example.roomapp.model.SensorData;
import com.example.roomapp.view.DetailFragment;
import com.example.roomapp.viewmodel.AppViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.CustomHolder> {
    private LayoutInflater inflater;
    private List<MainRecyclerModel> adapterDataList;
    private AppViewModel appViewModel;

    public MainRecyclerAdapter(List<MainRecyclerModel> mainRecyclerModels,AppViewModel mAppViewModel){
        this.adapterDataList = mainRecyclerModels;
        this.appViewModel = mAppViewModel;
    }


    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
         ItemRecyclerBinding itemRecyclerBinding = DataBindingUtil.inflate(inflater, R.layout.recycle_item,parent,false);

        return new CustomHolder(itemRecyclerBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, int position) {

        MainRecyclerModel adapterData = adapterDataList.get(position);
        holder.bind(adapterData);

        if(adapterData.listSensorData.isEmpty())return;
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                appViewModel.getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .add(
                                new DetailFragment(adapterData.listSensorData)
                                ,DetailFragment.TAG)
                        .commit();

                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return adapterDataList.size();
    }

    static class CustomHolder extends RecyclerView.ViewHolder{

        private final ItemRecyclerBinding itemRecyclerBinding;

        public CustomHolder(@NonNull ItemRecyclerBinding item) {
            super(item.getRoot());
            this.itemRecyclerBinding = item;
        }
        private void bind(MainRecyclerModel adapterData){

            this.itemRecyclerBinding.setItem(adapterData);
            this.itemRecyclerBinding.setFakedata("NaN");
            this.itemRecyclerBinding.executePendingBindings();

        }

        public ItemRecyclerBinding getItemRecyclerBinding() {
            return itemRecyclerBinding;
        }
    }

}
