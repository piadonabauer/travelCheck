package com.example.holiday.result.data;

import android.content.Context;

import com.example.holiday.result.HotelDataListener;

import java.util.ArrayList;
import java.util.List;

// manages all the hoteldata and provides it for the use

public class HotelDataProvider implements HotelDataRequest.RequestListener {

    private final Context context;
    private final HotelDataListener listener;
    private ArrayList<HotelData> currentData;

    public HotelDataProvider(Context context, HotelDataListener listener) {
        this.context = context;
        this.listener = listener;
        this.currentData = new ArrayList<>();
    }

    public void makeRequest(String city) {
        HotelDataRequest req = new HotelDataRequest(city, context);
        req.run(this);
    }

    @Override
    public void onResult(HotelData data) {
        currentData.add(data);
        listener.onHotelDataUpdated();
    }

    public ArrayList<HotelData> getCurrentData() {
        return currentData;
    }

    @Override
    public void onQueryResult(List<HotelData> dataList) {
        this.currentData.addAll(dataList);
        listener.onHotelDataUpdated();
    }

    public void addHotelData(HotelData data) {
        currentData.add(data);
    }

    public ArrayList<HotelData> getHotelData() {
        return currentData;
    }
}


