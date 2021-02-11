package com.example.roomapp.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.roomapp.R;
import com.example.roomapp.databinding.ItemDetailRecyclerBinding;
import com.example.roomapp.model.SensorData;
import java.util.List;

public class DetailRecyclerAdapter extends RecyclerView.Adapter<DetailRecyclerAdapter.CustomHolder> {
    List<SensorData> sensorDataList;
    private LayoutInflater inflater;

    public DetailRecyclerAdapter(List<SensorData> sensorData){

        this.sensorDataList = sensorData;
    }
    @NonNull
    @Override
    public DetailRecyclerAdapter.CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        ItemDetailRecyclerBinding itemDetailRecyclerBinding = DataBindingUtil.inflate(inflater, R.layout.detail_list_item,parent,false);

        return new DetailRecyclerAdapter.CustomHolder(itemDetailRecyclerBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailRecyclerAdapter.CustomHolder holder, int position) {
        SensorData sensorData = sensorDataList.get(position);
        holder.bind(sensorData);


    }

    @Override
    public int getItemCount() {
        return sensorDataList.size();
    }

    public class CustomHolder extends RecyclerView.ViewHolder {
        private final ItemDetailRecyclerBinding itemDetailRecyclerBinding;
        public CustomHolder(@NonNull ItemDetailRecyclerBinding item) {
            super(item.getRoot());
            this.itemDetailRecyclerBinding = item;
        }
        private void bind(SensorData sensorData){
            this.itemDetailRecyclerBinding.setItem(sensorData);
            this.itemDetailRecyclerBinding.executePendingBindings();

        }

        public ItemDetailRecyclerBinding getItemDetailRecyclerBinding() {
            return itemDetailRecyclerBinding;
        }

    }
}
