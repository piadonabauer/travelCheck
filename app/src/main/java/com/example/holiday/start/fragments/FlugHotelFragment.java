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
import android.widget.TextView;

import com.example.holiday.result.ResultActivity;
import com.example.holiday.start.data.DatePicker;
import com.example.holiday.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;

// fragment for choosing flight and hotel - input

public class FlugHotelFragment extends Fragment implements DatePicker.OnDateChangedListener {

    private Button startDate, endDate, startSearchButton;
    private EditText travelDestination, numAdults, numKids, airport;
    private TextView airports;
    private FloatingActionButton addAirportsButton;
    private ArrayList<String> airportList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_flug_hotel, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        airportList = new ArrayList<>();
        initInformation(view);
        initDatePicker(view);
        initSearchButton(view);
        initAddButton(view);
    }

    private void initInformation(View view) {
        travelDestination = view.findViewById(R.id.city);
        numAdults = view.findViewById(R.id.numAdults);
        numKids = view.findViewById(R.id.numKids);
        airport = view.findViewById(R.id.airport_place);
        airports = view.findViewById(R.id.alreadyEnteredAirplanePlaces);
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
                intent.putExtra("AIRPORTS", airportList);
                startActivity(intent);
            }
        });
    }

    private void initAddButton(View view) {
        addAirportsButton = view.findViewById(R.id.add_airport_button);
        addAirportsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (airport.getText().toString() != "") {
                    airportList.add(airport.getText().toString());
                    airport.setText("");
                    airports.setText("Flughäfen: " + Arrays.toString(airportList.toArray()).replace("[", "").replace("]", ""));
                }
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