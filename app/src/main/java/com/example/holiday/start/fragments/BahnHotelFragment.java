package com.example.holiday.start.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.holiday.result.ResultActivity;
import com.example.holiday.start.data.DatePicker;
import com.example.holiday.R;

// fragment for choosing train and hotel - input

public class BahnHotelFragment extends Fragment implements DatePicker.OnDateChangedListener {

    private Button startDate, endDate, startSearchButton;
    private EditText travelDestination, numAdults, numKids, trainstation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bahn_hotel, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        initInformation(view);
        initDatePicker(view);
        initSearchButton(view);
    }

    private void initInformation(View view) {
        travelDestination = view.findViewById(R.id.city);
        numAdults = view.findViewById(R.id.numAdults);
        numKids = view.findViewById(R.id.numKids);
        trainstation = view.findViewById(R.id.trainstation_place);
    }

    private void initDatePicker(View view) {
        startDate = view.findViewById(R.id.datePickerButton);
        endDate = view.findViewById(R.id.datePickerButton2);

        DatePicker datePicker = new DatePicker(this, getContext());

        startDate.setText(datePicker.getTodaysDate());
        endDate.setText(datePicker.getTodaysDate());

        setListenerOnDate(datePicker);
    }

    private void setListenerOnDate(DatePicker datePicker) {
        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.openDatePicker(view);
            }
        });

        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.openDatePicker(view);
            }
        });
    }

    private void initSearchButton(View view) {
        startSearchButton = view.findViewById(R.id.startSearchButton);
        startSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ResultActivity.class);
                intent.putExtra("DESTINATION", travelDestination.getText());
                intent.putExtra("START_DATE", startDate.getAutofillValue());
                intent.putExtra("END_DATE", endDate.getAutofillValue());
                intent.putExtra("NUMBER_ADULTS", numAdults.getText());
                intent.putExtra("NUMBER_KIDS", numKids.getText());
                intent.putExtra("TRAIN_STATION", trainstation.getText());
                startActivity(intent);
            }
        });
    }

    @Override
    public void dateChanged(View view, String date) {
        switch (view.getId()) {
            case R.id.datePickerButton:
                startDate.setText(date);
                break;
            case R.id.datePickerButton2:
                endDate.setText(date);
                break;
        }
    }
}