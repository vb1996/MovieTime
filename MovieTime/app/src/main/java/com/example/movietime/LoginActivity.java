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

public class LoginActivity extends AppCompatActivity {
    EditText email, password;
    Button login, signup;
    TextView textView;
    FirebaseAuth firebaseAuth;
    String mail,pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.editemail);
        password = findViewById(R.id.editpassword);
        textView = findViewById(R.id.fpwd);
        login = findViewById(R.id.loginbtn);
        signup = findViewById(R.id.signupbtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth = FirebaseAuth.getInstance();
             mail = email.getText().toString();
             pwd = password.getText().toString();
                if (TextUtils.isEmpty(mail)) {
                    email.setError("Enter Email");
                }
                if (TextUtils.isEmpty(pwd)) {

                    password.setError("Enter Password");
                }
                if (pwd.length() >= 10) {
                    password.setError("Enter password < 10");
                }

                firebaseAuth.signInWithEmailAndPassword(mail, pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Logged in", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, PartnerSelection.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "Failed Login", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fpwd = new Intent(getApplicationContext(), ForgotPassword.class);
                startActivity(fpwd);
            }
        });
    }
}


