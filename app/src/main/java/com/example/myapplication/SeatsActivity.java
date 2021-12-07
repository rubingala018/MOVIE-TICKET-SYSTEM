package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SeatsActivity extends AppCompatActivity {

    TextView movie_title, theatre_name, date1, time1,
            sc1, sc2, sc3, sc4, sc5, sp1, sp2, sp3, sp4, sp5, sv1, sv2, sv3, sv4, sv5;
    String title, date, time;
    Button pay_btn;
    LinearLayout vip_seats;
    int money=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats);
        getSupportActionBar().hide();

        title = getIntent().getStringExtra("title");
        date = getIntent().getStringExtra("date");
        time = getIntent().getStringExtra("time");
        movie_title = findViewById(R.id.movie_name);
        theatre_name = findViewById(R.id.theatre);
        date1 = findViewById(R.id.date_1);
        time1 = findViewById(R.id.time_1);
        pay_btn = findViewById(R.id.pay);
        vip_seats = findViewById(R.id.vip);

        sc1 = findViewById(R.id.c1);
        sc2 = findViewById(R.id.c2);
        sc3 = findViewById(R.id.c3);
        sc4 = findViewById(R.id.c4);
        sc5 = findViewById(R.id.c5);
        sp1 = findViewById(R.id.p1);
        sp2 = findViewById(R.id.p2);
        sp3 = findViewById(R.id.p3);
        sp4 = findViewById(R.id.p4);
        sp5 = findViewById(R.id.p5);
        sv1 = findViewById(R.id.v1);
        sv2 = findViewById(R.id.v2);
        sv3 = findViewById(R.id.v3);
        sv4 = findViewById(R.id.v4);
        sv5 = findViewById(R.id.v5);

        sv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=money+300;
                checkSelection(sv1);
            }
        });
        sv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=money+300;
                checkSelection(sv2);
            }
        });
        sv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=money+300;
                checkSelection(sv3);
            }
        });
        sv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=money+300;
                checkSelection(sv4);
            }
        });
        sv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=money+300;
                checkSelection(sv5);
            }
        });
        sp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=money+200;
                checkSelection(sp1);
            }
        });
        sp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=money+200;
                checkSelection(sp2);
            }
        });

        sp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=money+200;
                checkSelection(sp3);
            }
        });

        sp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=money+200;
                checkSelection(sp4);
            }
        });

        sp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=money+200;
                checkSelection(sp5);
            }
        });

        sc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=money+160;
                checkSelection(sc1);
            }
        });
        sc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=money+160;
                checkSelection(sc2);
            }
        });
        sc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=money+160;
                checkSelection(sc3);
            }
        });

        sc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=money+160;
                checkSelection(sc4);
            }
        });

        sc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                money=money+160;
                checkSelection(sc5);
            }
        });
    }

    private void checkSelection(TextView v1) {
        if (v1.getBackground().getConstantState()==getResources().getDrawable(R.drawable.available).getConstantState()) {
            v1.setBackgroundResource(R.drawable.selected);
            v1.setTextColor(Color.WHITE);
        } else if (v1.getBackground().getConstantState()==getResources().getDrawable(R.drawable.selected).getConstantState()) {
            v1.setBackgroundResource(R.drawable.available);
            v1.setTextColor(Color.GRAY);
        }
        pay_btn.setText("PAY "+ money);
    }
}