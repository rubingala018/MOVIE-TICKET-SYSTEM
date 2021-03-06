package com.example.myapplication.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.PurchaseHistoryActivity;
import com.example.myapplication.R;
import com.example.myapplication.RegisterActivity;
import com.example.myapplication.databinding.ActivityPurchasehistoryBinding;
import com.example.myapplication.databinding.FragmentBlankBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfileFrag extends Fragment {
    FirebaseDatabase database;
    FirebaseAuth auth;
    Context context;
    FragmentBlankBinding binding;
    String name,email;

    public ProfileFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        binding = FragmentBlankBinding.inflate(inflater, container, false);
        binding.logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                startActivity(new Intent(getContext(), RegisterActivity.class));
            }
        });
        database.getReference("User").child(auth.getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                name = "" + snapshot.child("username").getValue();
                email = "" + snapshot.child("email").getValue();
                binding.name.setText(name);
                binding.email1.setText(email);
                binding.username1.setText("Hi " + name+ "!!");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        binding.buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PurchaseHistoryActivity.class);
                intent.putExtra("username", name);
                startActivity(intent);
            }
        });

        return binding.getRoot();
    }
}