package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SeatsActivity extends AppCompatActivity {

    TextView movie_title, theatre_name, date1, time1,
            sc1, sc2, sc3, sc4, sc5, sp1, sp2, sp3, sp4, sp5, sv1, sv2, sv3, sv4, sv5;
    String title, date, time,theatrename;
    Button pay_btn;
    LinearLayout vip_seats;
    int money=0;
    FirebaseDatabase database;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats);
        getSupportActionBar().hide();

        database=FirebaseDatabase.getInstance();
        auth=FirebaseAuth.getInstance();

        title = getIntent().getStringExtra("title");
        date = getIntent().getStringExtra("date");
        time = getIntent().getStringExtra("time");
        theatrename = getIntent().getStringExtra("Theatre");
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
                checkSelection(sv1);
            }
        });
        sv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkSelection(sv2);
            }
        });
        sv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkSelection(sv3);
            }
        });
        sv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkSelection(sv4);
            }
        });
        sv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkSelection(sv5);
            }
        });
        sp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkSelection(sp1);
            }
        });
        sp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkSelection(sp2);
            }
        });

        sp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkSelection(sp3);
            }
        });

        sp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkSelection(sp4);
            }
        });

        sp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkSelection(sp5);
            }
        });

        sc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkSelection(sc1);
            }
        });
        sc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkSelection(sc2);
            }
        });
        sc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkSelection(sc3);
            }
        });

        sc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkSelection(sc4);
            }
        });

        sc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkSelection(sc5);
            }
        });

        pay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SeatsActivity.this,FinalTicketActivity.class);
                String cur_time= String.valueOf(System.currentTimeMillis());
                intent.putExtra("TicketId",cur_time);
                intent.putExtra("title",title);
                intent.putExtra("date",date);
                intent.putExtra("time",time);
                intent.putExtra("theatre",theatrename);
                startActivity(intent);
                HashMap<String,Object> hashMap=new HashMap();
                hashMap.put("Tickeid",cur_time);
                hashMap.put("title",title);
                hashMap.put("date",date);
                hashMap.put("time",time);
                hashMap.put("theatre",theatrename);
                hashMap.put("price",money);
                database.getReference("User").child(auth.getCurrentUser().getUid()).child(cur_time).updateChildren(hashMap);
            }
        });
    }

    private void checkSelection(TextView v1) {
        if (v1.getBackground().getConstantState()==getResources().getDrawable(R.drawable.available).getConstantState()) {
            v1.setBackgroundResource(R.drawable.selected);
            v1.setTextColor(Color.WHITE);
            money=money+200;
        } else if (v1.getBackground().getConstantState()==getResources().getDrawable(R.drawable.selected).getConstantState()) {
            v1.setBackgroundResource(R.drawable.available);
            v1.setTextColor(Color.GRAY);
            money=money-200;
        }
        pay_btn.setText("PAY "+ money);
    }
}