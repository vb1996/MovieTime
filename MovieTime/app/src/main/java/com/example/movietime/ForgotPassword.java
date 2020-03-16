package com.example.movietime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ForgotPassword extends AppCompatActivity {
    EditText email,pass,cpass;
    Button fwdbtn;
    String femail,fpass,confrim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        email=findViewById(R.id.emailtext);
        pass=findViewById(R.id.passtext);
        cpass=findViewById(R.id.confrimpasstext);
        fwdbtn=findViewById(R.id.forgotpass);
         femail=email.getText().toString();
         fpass=pass.getText().toString();
         confrim=cpass.getText().toString();
        fwdbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(femail)){
                    email.setError("Enter E-Mail");
                }
              else if (TextUtils.isEmpty(fpass)){

                    pass.setError("Enter Password");

                }
                else if (!TextUtils.equals(fpass,confrim)){
                    pass.setError("Password doesnt match");
                }
                else if (TextUtils.isEmpty(femail)&& TextUtils.isEmpty(fpass)){
                    email.setError("Enter Email & Password");
                }
                Intent login=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(login);
            }
        });

    }
}
