package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BookSeatsActivity extends AppCompatActivity {
    String title,photo_url,rating,lang,release_date,overview;
    TextView date1, date2, date3, date4, date5, date6,date7;
    TextView time1, time2, time3,time4,time5,time6,time7;
    String theatre;
    TextView movietitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_seats);

        title=getIntent().getStringExtra("title");
        photo_url=getIntent().getStringExtra("photo");
        rating=getIntent().getStringExtra("rating");
        lang=getIntent().getStringExtra("lang");
        release_date=getIntent().getStringExtra("release_date");
        overview=getIntent().getStringExtra("overview");

        getSupportActionBar().hide();
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 0);

        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DATE, 1);

        Calendar c2 = Calendar.getInstance();
        c2.add(Calendar.DATE, 2);

        Calendar c3 = Calendar.getInstance();
        c3.add(Calendar.DATE, 3);

        Calendar c4 = Calendar.getInstance();
        c4.add(Calendar.DATE, 4);

        Calendar c5 = Calendar.getInstance();
        c5.add(Calendar.DATE, 5);

        Calendar c6 = Calendar.getInstance();
        c6.add(Calendar.DATE, 6);

        date1=findViewById(R.id.d1);
        date2=findViewById(R.id.d2);
        date3=findViewById(R.id.d3);
        date4=findViewById(R.id.d4);
        date5=findViewById(R.id.d5);
        date6=findViewById(R.id.d6);
        date7=findViewById(R.id.d7);

        time1=findViewById(R.id.t1);
        time2=findViewById(R.id.t2);
        time3=findViewById(R.id.t3);
        time4=findViewById(R.id.t4);
        time5=findViewById(R.id.t5);
        time6=findViewById(R.id.t6);
        time7=findViewById(R.id.t7);

        //movietitle.setText(title);
        date1.setText(dateFormat.format(c.getTime()));
        date2.setText(dateFormat.format(c1.getTime()));
        date3.setText(dateFormat.format(c2.getTime()));
        date4.setText(dateFormat.format(c3.getTime()));
        date5.setText(dateFormat.format(c4.getTime()));
        date6.setText(dateFormat.format(c5.getTime()));
        date7.setText(dateFormat.format(c6.getTime()));

        time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(BookSeatsActivity.this,MainActivity.class);
                intent.putExtra("Theatre","Theatre 1");
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });










    }
}