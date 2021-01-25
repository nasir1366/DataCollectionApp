package com.example.roomapp.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomapp.R;
import com.example.roomapp.databinding.ItemStationBinding;
import com.example.roomapp.model.Station;
import com.example.roomapp.viewmodel.StationViewModel;

import java.util.ArrayList;
import java.util.List;

public class StationAdapter extends RecyclerView.Adapter<StationAdapter.CustomHolder> {
    private LayoutInflater inflater;
    private List<Station> stations;

    public StationAdapter(List<Station> dataList){
        stations = new ArrayList<>();
        this.stations = dataList;
    }

    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
         ItemStationBinding itemStationBinding = DataBindingUtil.inflate(inflater, R.layout.item_station,parent,false);

        return new CustomHolder(itemStationBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, int position) {
        Station station = stations.get(position);
        holder.bind(station);
    }

    @Override
    public int getItemCount() {
        return stations.size();
    }

    static class CustomHolder extends RecyclerView.ViewHolder{

        private final ItemStationBinding itemStationBinding;

        public CustomHolder(@NonNull ItemStationBinding itemStationBinding) {
            super(itemStationBinding.getRoot());
            this.itemStationBinding = itemStationBinding;
        }
        private void bind(Station station){
            this.itemStationBinding.setItem(station);
            this.itemStationBinding.executePendingBindings();
        }

        public ItemStationBinding getItemStationBinding() {
            return itemStationBinding;
        }
    }

}
