package com.example.holiday.start;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Button;

import com.example.holiday.R;
import com.example.holiday.start.ui.ViewPagerStart;
import com.google.android.material.tabs.TabLayout;

// first activity, is shown when starting the app

public class StartActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    private void initUI() {
        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewpager);
        ViewPagerStart viewPagerStart = new ViewPagerStart(tabLayout, viewPager, getSupportFragmentManager());
    }
}