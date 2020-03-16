package com.example.movietime;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PartnerAdapter extends  RecyclerView.Adapter<PartnerAdapter.ViewHolder>{
List<PartnerData>Data;
    Context context;

    public PartnerAdapter(List<PartnerData> data, Context context) {
        this.Data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public PartnerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.partnerlist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PartnerAdapter.ViewHolder holder, int position) {
        final PartnerData partnerData=Data.get(position);
        holder.nameofpartner.setText(partnerData.getPartnerName());
        holder.ageofpartner.setText(partnerData.getPartnerAge());
        holder.decriptionofpartner.setText(partnerData.getPartnerQualification());
        holder.imageofpartner.setImageDrawable(context.getResources().getDrawable(partnerData.partnerimage));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,PartnerConfirmationPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Partnerimage",partnerData.getPartnerimage());
                intent.putExtra("Partnername",partnerData.getPartnerName());
                intent.putExtra("Partnerage",partnerData.getPartnerAge());
                intent.putExtra("Partnerdescription",partnerData.getPartnerQualification());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return Data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
ImageView imageofpartner;
TextView nameofpartner,ageofpartner,decriptionofpartner;
RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
imageofpartner=itemView.findViewById(R.id.Partner_image);
nameofpartner=itemView.findViewById(R.id.Partner_name);
ageofpartner=itemView.findViewById(R.id.Partner_age);
decriptionofpartner=itemView.findViewById(R.id.Partner_description);
relativeLayout=itemView.findViewById(R.id.relativelist);
        }
    }
}
