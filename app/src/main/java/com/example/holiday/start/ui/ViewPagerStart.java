package com.example.holiday.start.ui;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.example.holiday.start.fragments.BahnHotelFragment;
import com.example.holiday.start.fragments.FlugHotelFragment;
import com.example.holiday.start.fragments.HotelFragment;
import com.google.android.material.tabs.TabLayout;

// class for handling the viewpager

public class ViewPagerStart {

    private TabLayout tabLayout;
    private androidx.viewpager.widget.ViewPager viewPager;
    private FragmentManager manager;

    public ViewPagerStart(TabLayout tabLayout, ViewPager viewPager, FragmentManager manager) {
        this.tabLayout = tabLayout;
        this.viewPager = viewPager;
        this.manager = manager;
        init();
    }

    private void init() {
        tabLayout.setupWithViewPager(viewPager);
        VPAdapter vpAdapter = new VPAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new FlugHotelFragment(), "Flug&Hotel");
        vpAdapter.addFragment(new BahnHotelFragment(), "Bahn&Hotel");
        vpAdapter.addFragment(new HotelFragment(), "Hotel");
        viewPager.setAdapter(vpAdapter);
        viewPager.setPageMargin(20);
    }
}
