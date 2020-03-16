package com.example.movietime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MotionEventCompat;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MovieActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

Button payment;
Spinner spinner;
TextView showdialog;
String movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        payment=findViewById(R.id.ptmbutton);
        spinner=findViewById(R.id.moviespinner);
        showdialog=findViewById(R.id.dialog);
        List<String> Movielist=new ArrayList<>();
        Movielist.add(0,"Select Movie");
        Movielist.add(1,"Detective");
        Movielist.add(2,"HIT");
        Movielist.add(3,"Transformers");
        Movielist.add(4,"China Town");
        Movielist.add(5,"Bala");
        Movielist.add(6,"Gully Boy");
        Movielist.add(7,"Fast & Furious 9");

        ArrayAdapter<String> movieadapter;
         movieadapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,Movielist);
         movieadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         spinner.setAdapter(movieadapter);
spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
        if (adapterView.getItemAtPosition(i).equals("Select Movie")){

        }
        else{
            movie=adapterView.getItemAtPosition(i).toString();
            Toast.makeText(MovieActivity.this,"Selected Movie"+movie,Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }
});

showdialog.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        showselecteddate();

    }
});
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moviepage=new Intent(getApplicationContext(),PaymentPage.class);
                startActivity(moviepage);
            }
        });


    }
    public void showselecteddate(){
        DatePickerDialog datePickerDialog=new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date=month+"/"+dayOfMonth+"/"+year;
        showdialog.setText(date);

    }
}
