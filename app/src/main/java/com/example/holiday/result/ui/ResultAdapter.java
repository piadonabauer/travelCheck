package com.example.holiday.result.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.holiday.result.data.HotelData;
import com.example.holiday.R;

import java.util.ArrayList;

//Adapter for showing the data within a recyclerview

public class ResultAdapter extends RecyclerView.Adapter<ResultViewHolder> {

    private ArrayList<HotelData> currentHotelList;
    private final Context context;

    public ResultAdapter(Context context) {
        currentHotelList = new ArrayList<>();
        this.context = context;
    }

    public void setData(ArrayList<HotelData> data) {
        currentHotelList.clear();
        this.currentHotelList.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ResultViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        holder.bindView(currentHotelList.get(position));
    }


    @Override
    public int getItemCount() {
        if (currentHotelList.size() == 0) {
            return 1;
        }
        return currentHotelList.size();
    }
}

