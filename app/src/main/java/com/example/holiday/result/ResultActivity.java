package com.example.holiday.result;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.holiday.result.data.HotelData;
import com.example.holiday.R;
import com.example.holiday.result.data.HotelDataProvider;
import com.example.holiday.result.ui.FilterFragment;
import com.example.holiday.result.ui.ResultAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

//Activity for showing the results of the search

public class ResultActivity extends AppCompatActivity implements HotelDataListener {

    private HotelDataProvider provider;
    private ResultAdapter resultAdapter;
    private RecyclerView recyclerView;
    private FloatingActionButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        initComponents();
        initUI();
    }

    private void initComponents() {
        resultAdapter = new ResultAdapter(this);
        recyclerView = findViewById(R.id.data_recyclerview);
        recyclerView.setAdapter(resultAdapter);
        provider = new HotelDataProvider(this, this);
    }

    private void initUI() {
        initButton();
        initExampleData();
    }

    private void initButton() {
        button = findViewById(R.id.filter_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFragment();
            }
        });
    }

    private void startFragment() {
        FilterFragment filterFragment = new FilterFragment();
        filterFragment.show(getSupportFragmentManager(), "filter");
    }

    //example data to see the representation of the offers

    private void initExampleData() {
        HotelData data1 = new HotelData("Berlin", "Sunny Hotel", 3, 276);
        HotelData data2 = new HotelData("Berlin", "Markado", 5, 499);
        HotelData data3 = new HotelData("Berlin", "Marionett", 5, 322);
        HotelData data4 = new HotelData("Berlin", "BlueTones", 1, 95);
        HotelData data5 = new HotelData("Berlin", "Hauner Hotels", 4, 300);
        provider.addHotelData(data1);
        provider.addHotelData(data2);
        provider.addHotelData(data3);
        provider.addHotelData(data4);
        provider.addHotelData(data5);

        resultAdapter.setData(provider.getCurrentData());
        resultAdapter.notifyDataSetChanged();
        if (resultAdapter != null) {
            resultAdapter.setData(provider.getCurrentData());
            resultAdapter.notifyDataSetChanged();
            recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        }
    }


    @Override
    public void onHotelDataUpdated() {
        updateAdapterHotelData(provider.getCurrentData());
    }

    private void updateAdapterHotelData(ArrayList<HotelData> currentData) {
    }
}
