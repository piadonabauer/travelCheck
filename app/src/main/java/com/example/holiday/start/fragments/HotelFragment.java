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

// fragment for choosing a hotel - input

public class HotelFragment extends Fragment implements DatePicker.OnDateChangedListener {

    private Button startDate, endDate, startSearchButton;
    private EditText travelDestination, numAdults, numKids, numRoom;

    //private AutocompleteSupportFragment autocompleteFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hotel, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initInformation(view);
        initDatePicker(view);
        //initPlacePicker();
        initSearchButton(view);
    }

    private void initInformation(View view) {
        travelDestination = view.findViewById(R.id.city);
        numAdults = view.findViewById(R.id.numAdults);
        numKids = view.findViewById(R.id.numKids);
        numRoom = view.findViewById(R.id.rooms);
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
                intent.putExtra("NUMBER_ROOMS", numRoom.getText());
                startActivity(intent);
            }
        });
    }

    //trying to use autocomplete for typing a place

    /*
    private void initPlacePicker() {
        FragmentManager manager = getChildFragmentManager();
        autocompleteFragment =  (AutocompleteSupportFragment) manager.findFragmentById(R.id.autocomplete_fragment);
        //PlacePicker placePicker = new PlacePicker(this, getContext(), autocompleteFragment);
        if (!Places.isInitialized()) {
            Places.initialize(getContext(), "YOUR_API_KEY");
        }
        PlacesClient placesClient = Places.createClient(getContext());
        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(@NonNull Place place) {
                autocompleteFragment.setHint(place.getName());
            }

            @Override
            public void onError(@NonNull Status status) {
                Toast.makeText(getContext(), "Fehler bei der Eingabe des Ortes!", Toast.LENGTH_SHORT).show();
            }
        });
    }


     */
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