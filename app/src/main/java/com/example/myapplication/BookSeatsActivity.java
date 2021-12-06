package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BookSeatsActivity extends AppCompatActivity {
    String title, photo_url, rating, lang, release_date, overview;
    TextView date1, date2, date3, date4, date5, date6, date7;
    TextView time1, time2, time3, time4, time5, time6, time7;
    String theatre;
    TextView movietitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_seats);

        title = getIntent().getStringExtra("title");
        photo_url = getIntent().getStringExtra("photo");
        rating = getIntent().getStringExtra("rating");
        lang = getIntent().getStringExtra("lang");
        release_date = getIntent().getStringExtra("release_date");
        overview = getIntent().getStringExtra("overview");
        Date date=new Date();

        getSupportActionBar().hide();
        DateFormat dateFormat2 = new SimpleDateFormat("dd/mm/yyyy");
        DateFormat dateFormat = new SimpleDateFormat("dd");
        Calendar c = Calendar.getInstance();
       // c.setTimeZone(TimeZone.getTimeZone("IST"));
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

        date1 = findViewById(R.id.d1);
        date2 = findViewById(R.id.d2);
        date3 = findViewById(R.id.d3);
        date4 = findViewById(R.id.d4);
        date5 = findViewById(R.id.d5);
        date6 = findViewById(R.id.d6);
        date7 = findViewById(R.id.d7);

        time1 = findViewById(R.id.t1);
        time2 = findViewById(R.id.t2);
        time3 = findViewById(R.id.t3);
        time4 = findViewById(R.id.t4);
        time5 = findViewById(R.id.t5);
        time6 = findViewById(R.id.t6);
        time7 = findViewById(R.id.t7);
        movietitle=findViewById(R.id.movie_title1);

        String[] strDays = new String[] { "SUN", "MON", "TUE","WED", "THU","FRI", "SAT" };

        movietitle.setText(title);

        date1.setText(strDays[c.getTime().getDay()]+"\n"+dateFormat.format(c.getTime()));
        date2.setText(strDays[c1.getTime().getDay()]+"\n"+dateFormat.format(c1.getTime()));
        date3.setText(strDays[c2.getTime().getDay()]+"\n"+dateFormat.format(c2.getTime()));
        date4.setText(strDays[c3.getTime().getDay()]+"\n"+dateFormat.format(c3.getTime()));
        date5.setText(strDays[c4.getTime().getDay()]+"\n"+dateFormat.format(c4.getTime()));
        date6.setText(strDays[c5.getTime().getDay()]+"\n"+dateFormat.format(c5.getTime()));
        date7.setText(strDays[c6.getTime().getDay()]+"\n"+dateFormat.format(c6.getTime()));

        date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotSelected();
                currentSelected(date1.getId());
            }
        });
        date2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotSelected();
                currentSelected(date2.getId());
            }
        });
        date3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotSelected();
                currentSelected(date3.getId());
            }
        });
        date4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotSelected();
                currentSelected(date4.getId());
            }
        });
        date5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotSelected();
                currentSelected(date5.getId());
            }
        });
        date6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotSelected();
                currentSelected(date6.getId());
            }
        });
        date7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotSelected();
                currentSelected(date7.getId());
            }
        });


        time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookSeatsActivity.this, MainActivity.class);
                intent.putExtra("Theatre", "Theatre 1");
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });
    }

    private void NotSelected() {
        date1.setBackgroundColor(Color.WHITE);
        date1.setTextColor(Color.BLACK);

        date2.setBackgroundColor(Color.WHITE);
        date2.setTextColor(Color.BLACK);

        date3.setBackgroundColor(Color.WHITE);
        date3.setTextColor(Color.BLACK);

        date4.setBackgroundColor(Color.WHITE);
        date4.setTextColor(Color.BLACK);

        date5.setBackgroundColor(Color.WHITE);
        date5.setTextColor(Color.BLACK);

        date6.setBackgroundColor(Color.WHITE);
        date6.setTextColor(Color.BLACK);

        date7.setBackgroundColor(Color.WHITE);
        date7.setTextColor(Color.BLACK);
    }

    private void currentSelected(int id) {
        if (id == R.id.d1) {
            date1.setBackgroundColor(Color.rgb(192, 202, 51));
            date1.setTextColor(Color.WHITE);
        } else if (id == R.id.d2) {
            date2.setBackgroundColor(Color.rgb(192, 202, 51));
            date2.setTextColor(Color.WHITE);
        } else if (id == R.id.d3) {
            date3.setBackgroundColor(Color.rgb(192, 202, 51));
            date3.setTextColor(Color.WHITE);
        } else if (id == R.id.d4) {
            date4.setBackgroundColor(Color.rgb(192, 202, 51));
            date4.setTextColor(Color.WHITE);
        } else if (id == R.id.d5) {
            date5.setBackgroundColor(Color.rgb(192, 202, 51));
            date5.setTextColor(Color.WHITE);
        } else if (id == R.id.d6) {
            date6.setBackgroundColor(Color.rgb(192, 202, 51));
            date6.setTextColor(Color.WHITE);
        } else if (id == R.id.d7) {
            date7.setBackgroundColor(Color.rgb(192, 202, 51));
            date7.setTextColor(Color.WHITE);
        }
    }
}