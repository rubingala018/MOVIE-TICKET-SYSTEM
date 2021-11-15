package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.example.myapplication.Adapter.FragmentAdpater;
import com.google.android.material.tabs.TabLayout;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        getSupportActionBar().hide();
        ViewPager viewPager;
        TabLayout tabLayout;

        viewPager=findViewById(R.id.viewPager);
        tabLayout=findViewById(R.id.tabLayout);

        viewPager.setAdapter(new FragmentAdpater(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }
}