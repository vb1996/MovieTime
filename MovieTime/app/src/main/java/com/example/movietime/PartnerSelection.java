package com.example.movietime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;

public class PartnerSelection extends AppCompatActivity {
    RecyclerView recyclerView;

    List<PartnerData> dataofpartner;

    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_selection);
        dataofpartner=new ArrayList<>();
        recyclerView=findViewById(R.id.partnerlist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataofpartner.add(new PartnerData(R.drawable.image1,"Sonia","25","Software Engineer"));
        dataofpartner.add(new PartnerData(R.drawable.image2,"Maria","26","Designer"));
        dataofpartner.add(new PartnerData(R.drawable.image3,"Thomas","27","Manager"));
        dataofpartner.add(new PartnerData(R.drawable.image4,"Naina","22","ShopKeeper"));
        dataofpartner.add(new PartnerData(R.drawable.image5,"James","24","Cineplex Manager"));
        dataofpartner.add(new PartnerData(R.drawable.image6,"Corbett","26","Designer"));
        dataofpartner.add(new PartnerData(R.drawable.image7,"Jean","27","Software Developer"));
        dataofpartner.add(new PartnerData(R.drawable.image8,"Mark","24","Automation Engineer"));
        adapter=new PartnerAdapter(dataofpartner,getApplicationContext());
        recyclerView.setAdapter(adapter);

    }
}
