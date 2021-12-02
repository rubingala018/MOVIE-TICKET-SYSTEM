package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BookSeatsActivity extends AppCompatActivity {
    String title,photo_url,rating,lang,release_date,overview;

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
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);

        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DATE, 2);

        Calendar c2 = Calendar.getInstance();
        c2.add(Calendar.DATE, 3);

        Calendar c3 = Calendar.getInstance();
        c3.add(Calendar.DATE, 4);

        Calendar c4 = Calendar.getInstance();
        c4.add(Calendar.DATE, 5);

        Calendar c5 = Calendar.getInstance();
        c5.add(Calendar.DATE, 6);

        Calendar c6 = Calendar.getInstance();
        c6.add(Calendar.DATE, 7);

    }
}