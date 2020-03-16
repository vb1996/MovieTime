package com.example.movietime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText Email,Password,Name,Lname;
    Button register;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Email=findViewById(R.id.emailtext);
        Password=findViewById(R.id.passtext);
        Name=findViewById(R.id.firstnametext);
        Lname=findViewById(R.id.lname);
        register=findViewById(R.id.signup);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth= FirebaseAuth.getInstance();
                final String mail=Email.getText().toString();
                String pwd=Password.getText().toString();
                String nm=Name.getText().toString();
                String lnm=Lname.getText().toString();
                if (TextUtils.isEmpty(mail)){
                    Email.setError("Enter Email");
                    return;
                }
                if (TextUtils.isEmpty(pwd)){
                    Password.setError("Enter Password");
                    return;
                }
                if (pwd.length()>=10){
                    Password.setError("Enter Password <=10");
                    return;
                }

                if (TextUtils.isEmpty(mail)&& TextUtils.isEmpty(pwd)){
                    Email.setError("Enter Email");
                    Password.setError("Enter Password");
                }

                if (TextUtils.isEmpty(nm)){
                    Name.setError("Enter First Name");
                    return;
                }
                if (TextUtils.isEmpty(lnm)) {
                    Lname.setError("Enter Last Name");
                    return;
                }
                firebaseAuth.createUserWithEmailAndPassword(mail,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"User Created",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                            //intent.putExtra("name",mail);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(MainActivity.this,"Registration failed",Toast.LENGTH_LONG).show();
                        }
                    }

                });
            }
        });


            }
        }


