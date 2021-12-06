package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SeatsActivity extends AppCompatActivity {

    TextView movie_title,theatre_name,date1,time1;
    LinearLayout sc1,sc2,sc3,sc4,sc5,sp1,sp2,sp3,sp4,sp5,sv1,sv2,sv3,sv4,sv5;
    String title,date,time;
    Button pay_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats);
        getSupportActionBar().hide();

        title=getIntent().getStringExtra("title");
        date=getIntent().getStringExtra("date");
        time=getIntent().getStringExtra("time");
        /*movie_title=findViewById(R.id.);
        theatre_name=findViewById(R.id.);
        date1=findViewById(R.id.);
        time1=findViewById(R.id.);
        pay_btn=findViewById(R.id.);

        sc1=findViewById(R.id.);
        sc2=findViewById(R.id.);
        sc3=findViewById(R.id.);
        sc4=findViewById(R.id.);
        sc5=findViewById(R.id.);
        sp1=findViewById(R.id.);
        sp2=findViewById(R.id.);
        sp3=findViewById(R.id.);
        sp4=findViewById(R.id.);
        sp5=findViewById(R.id.);
        sv1=findViewById(R.id.);
        sv2=findViewById(R.id.);
        sv3=findViewById(R.id.);
        sv4=findViewById(R.id.);
        sv5=findViewById(R.id.);*/

    }
}