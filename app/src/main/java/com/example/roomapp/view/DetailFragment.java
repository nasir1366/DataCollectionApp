package com.example.roomapp.view;

import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.roomapp.R;
import com.example.roomapp.databinding.FragmentDetailBinding;
import com.example.roomapp.model.DetailRecyclerModel;
import com.example.roomapp.model.SensorData;
import com.example.roomapp.viewmodel.AppViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class DetailFragment extends DialogFragment {

    public static String TAG = "DetailFragmentDialog";
    private List<SensorData> msensorDataList;

    public DetailFragment(List<SensorData> sensorDataList) {
        this.msensorDataList = sensorDataList;
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater
            , ViewGroup container
            ,Bundle savedInstanceState) {


        FragmentDetailBinding mBinding = DataBindingUtil.inflate(inflater
                , R.layout.fragment_detail
                ,container
                , false);

        mBinding.setLifecycleOwner(getViewLifecycleOwner());
        mBinding.setDetailRecyclerdata(new DetailRecyclerModel(msensorDataList));

        return mBinding.getRoot();
    }
}