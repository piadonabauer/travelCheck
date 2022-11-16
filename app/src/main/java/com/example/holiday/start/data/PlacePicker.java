package com.example.holiday.start.data;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.util.Arrays;

//trying to use Places API by Google for autocomplete while entering a place

public class PlacePicker extends Fragment {

    /*
    private OnPlaceChangedListener listener;
    private Context context;
    private AutocompleteSupportFragment autocompleteFragment;
    private String cityName = null;

    public PlacePicker(OnPlaceChangedListener listener, Context context, AutocompleteSupportFragment autocomplete) {
        this.listener = listener;
        this.context = context;
        if (!Places.isInitialized()) {
            Places.initialize(context, "YOUR_API_KEY");
        }
        this.autocompleteFragment = autocomplete;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager manager = getChildFragmentManager();
        setUp(manager);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        control();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void setUp(FragmentManager manager) {
        autocompleteFragment = (AutocompleteSupportFragment) manager.findFragmentById(R.id.autocomplete_fragment);
        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));

        autocompleteFragment.getView().findViewById(R.id.autocomplete_fragment).performClick();
    }

    private void control() {
        autocompleteFragment.getView().findViewById(R.id.autocomplete_fragment).performClick();
        autocompleteFragment.setHint("Reiseziel");

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(@NonNull Place place) {
                autocompleteFragment.getView().findViewById(R.id.autocomplete_fragment).performClick();
                listener.onPlaceChanged(place);
            }

            @Override
            public void onError(@NonNull Status status) {
                Toast.makeText(context, "Fehler bei der Eingabe des Ortes!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public interface OnPlaceChangedListener {
        void onPlaceChanged(Place place);
    }
     */
}


