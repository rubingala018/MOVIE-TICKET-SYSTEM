package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MoviesDescActivity extends AppCompatActivity {
    String title,photo_url,rating,lang,release_date,overview;
    TextView title_txt,rating_txt,lang_txt,release_date_txt,overview_txt;
    ImageView photo;
    Button book_tkt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_desc);

        getSupportActionBar().hide();

        title=getIntent().getStringExtra("title");
        photo_url=getIntent().getStringExtra("photo");
        rating=getIntent().getStringExtra("rating");
        lang=getIntent().getStringExtra("lang");
        release_date=getIntent().getStringExtra("release_date");
        overview=getIntent().getStringExtra("overview");
        

        /*title_txt=findViewById(R.id.);
        photo=findViewById(R.id.);
        rating_txt=findViewById(R.id.);
        lang_txt=findViewById(R.id.);
        release_date_txt=findViewById(R.id.);
        overview_txt=findViewById(R.id.);
        book_tkt=findViewById(R.id.);*/

        /*title_txt.setText(title);
        rating_txt.setText(rating);
        lang_txt.setText(lang);
        release_date_txt.setText(release_date);
        overview_txt.setText(overview);*/

       /* Glide.with(MoviesDescActivity.this).load(photo_url).into(photo);

        book_tkt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MoviesDescActivity.this,BookSeatsActivity.class);
                intent.putExtra("title",title);
                intent.putExtra("photo",photo_url);
                intent.putExtra("rating",rating);
                intent.putExtra("lang",lang);
                intent.putExtra("release_date",release_date);
                intent.putExtra("overview",overview);
                startActivity(intent);
            }
        });*/
    }
}