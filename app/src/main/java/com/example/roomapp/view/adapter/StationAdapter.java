package com.example.roomapp.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomapp.R;
import com.example.roomapp.databinding.ItemStationBinding;
import com.example.roomapp.viewmodel.StationViewModel;

import java.util.ArrayList;

public class StationAdapter extends RecyclerView.Adapter<StationAdapter.CustomHolder> {
    private ArrayList<StationViewModel> stationViewModels ;
    private LayoutInflater inflater;

    public StationAdapter(ArrayList<StationViewModel> arrayList){
        stationViewModels = new ArrayList<>();
        this.stationViewModels = arrayList;
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
        StationViewModel stationViewModel = stationViewModels.get(position);
        holder.bind(stationViewModel);
    }

    @Override
    public int getItemCount() {
        return stationViewModels.size();
    }

    static class CustomHolder extends RecyclerView.ViewHolder{

        private final ItemStationBinding itemStationBinding;

        public CustomHolder(@NonNull ItemStationBinding itemStationBinding) {
            super(itemStationBinding.getRoot());
            this.itemStationBinding = itemStationBinding;
        }
        private void bind(StationViewModel stationViewModel){
            this.itemStationBinding.setItem(stationViewModel);
            this.itemStationBinding.executePendingBindings();
        }

        public ItemStationBinding getItemStationBinding() {
            return itemStationBinding;
        }
    }

}
