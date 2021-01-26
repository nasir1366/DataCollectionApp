package com.example.roomapp.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.roomapp.R;
import com.example.roomapp.databinding.ItemRecyclerBinding;
import com.example.roomapp.model.MainRecyclerModel;

import java.util.ArrayList;
import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.CustomHolder> {
    private LayoutInflater inflater;
    private List<MainRecyclerModel> adapterDataList;

    public MainRecyclerAdapter(List<MainRecyclerModel> dataList){
        adapterDataList = new ArrayList<>();
        this.adapterDataList = dataList;
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
            this.itemRecyclerBinding.executePendingBindings();
        }

        public ItemRecyclerBinding getItemRecyclerBinding() {
            return itemRecyclerBinding;
        }
    }

}
