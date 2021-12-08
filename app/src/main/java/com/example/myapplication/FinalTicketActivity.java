package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityFinalTicketBinding;

public class FinalTicketActivity extends AppCompatActivity {
    ActivityFinalTicketBinding binding;
    String ticketid,title,date,time,theatrename,money,seats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFinalTicketBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        ticketid=getIntent().getStringExtra("TicketId");
        title=getIntent().getStringExtra("title");
        date=getIntent().getStringExtra("date");
        time=getIntent().getStringExtra("time");
        theatrename=getIntent().getStringExtra("Theatre");
        money=getIntent().getStringExtra("money");
        seats=getIntent().getStringExtra("seats");


        binding.ticketId.setText("TICKET ID: "+ ticketid);
        binding.nameMovie.setText(title);
        binding.tickDate.setText(date);
        binding.tickTheatre.setText(theatrename);
        binding.tickTime.setText(time);
        binding.tickPrice.setText(money);
        binding.tickSeatno.setText(seats);

        binding.goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FinalTicketActivity.this,HomePageActivity.class));
            }
        });
    }
}