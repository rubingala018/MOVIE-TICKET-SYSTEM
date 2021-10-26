package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {
    FirebaseDatabase database;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth= FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();


        setContentView(R.layout.activity_register);
        TextView reg_to_login;
        EditText username,email,pdw;
        Button register;
        reg_to_login=findViewById(R.id.reg__to_login);
        username=findViewById(R.id.username);
        email=findViewById(R.id.email_id);
        pdw=findViewById(R.id.pdw);
        register=findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.createUserWithEmailAndPassword(email.getText().toString(),pdw.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            HashMap<String,Object> hash=new HashMap<>();
                            hash.put("username",username.getText());
                            hash.put("email",email.getText());
                            hash.put("password",pdw.getText());
                            database.getReference("user").child(auth.getCurrentUser().getUid()).setValue(hash).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {

                                }
                            });
                        }
                        else {

                        }

                    }
                });

            }
        });

        reg_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,loginactivity.class);
                startActivity(intent);
            }
        });

}
}