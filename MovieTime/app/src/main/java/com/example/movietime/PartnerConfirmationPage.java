package com.example.movietime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PartnerConfirmationPage extends AppCompatActivity {

    ImageView imageView;
    TextView name,age,description;
    String partnername,partnerage,partnerdescription;
    int image;
    Button movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_confirmation_page);

        imageView=findViewById(R.id.nimage);
        name=findViewById(R.id.Partner_name);
        age=findViewById(R.id.Partner_age);
        description=findViewById(R.id.Partner_description);
        movie=findViewById(R.id.nextbtn);
        partnername=getIntent().getStringExtra("Partnername");
        partnerage=getIntent().getStringExtra("Partnerage");
        partnerdescription=getIntent().getStringExtra("Partnerdescription");
        image=getIntent().getIntExtra("Partnerimage",0);
        name.setText(partnername);
        age.setText(partnerage);
        description.setText(partnerdescription);
        imageView.setImageResource(image);

        movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent movie=new Intent(getApplicationContext(),MovieActivity.class);
                startActivity(movie);
            }
        });


    }
}
