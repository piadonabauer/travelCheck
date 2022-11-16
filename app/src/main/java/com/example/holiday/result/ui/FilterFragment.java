package com.example.holiday.result.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;

import com.example.holiday.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

//Fragment which opens when clicking the filtering button at the resultpage

public class FilterFragment extends androidx.fragment.app.DialogFragment {

    private SwitchCompat meerblick;
    private SwitchCompat vollpension;
    private SwitchCompat pool;
    private MaterialButton filterButton;
    private OnFilterChosenListener listener;

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View root = inflater.inflate(R.layout.fragment_filter, null);
        initUI(root);
        builder.setView(root);
        return builder.create();
    }

    private void initUI(View view) {
        meerblick = view.findViewById(R.id.switch1);
        meerblick.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                meerblick.setChecked(b);
                //listener.onFilterChosen(1, b);
            }
        });
        vollpension = view.findViewById(R.id.switch2);
        vollpension.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                vollpension.setChecked(b);
                //listener.onFilterChosen(2, b);
            }
        });
        pool = view.findViewById(R.id.switch3);
        pool.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                pool.setChecked(b);
                //listener.onFilterChosen(3, b);
            }
        });
        initButton(view);
    }

    private void initButton(View view) {
        filterButton = view.findViewById(R.id.confirm_button);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    public interface OnFilterChosenListener {
        void onFilterChosen(int switchNr, boolean checked);
    }

}
