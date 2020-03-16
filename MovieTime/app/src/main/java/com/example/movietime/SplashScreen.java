package com.example.movietime;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       /* new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash=new Intent(SplashScreen.this,MainActivity.class);
                startActivity(splash);
                finish();
            }
        },splashwaittime);*/

       Handler handler=new Handler();

       handler.postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent splash=new Intent(SplashScreen.this,LoginActivity.class);
               startActivity(splash);
               finish();

           }
       },3000);


    }
}
