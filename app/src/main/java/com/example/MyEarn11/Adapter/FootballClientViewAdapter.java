package com.example.MyEarn11.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.MyEarn11.FC01;
import com.example.MyEarn11.Model.ClientModel;
import com.example.MyEarn11.Model.FootballClientModel;
import com.example.MyEarn11.R;

import java.util.ArrayList;

public class FootballClientViewAdapter extends RecyclerView.Adapter<FootballClientViewAdapter.ViewHolder>{

    ArrayList<FootballClientModel> mData;
    Context context;

    public FootballClientViewAdapter(Context context, ArrayList<FootballClientModel> mData) {
        this.mData = mData;
        this.context = context;
    }

    @NonNull
    @Override
    public FootballClientViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.client_card, parent,false);
        return new FootballClientViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FootballClientViewAdapter.ViewHolder holder, int position) {
        FootballClientModel model = mData.get(position);

        holder.MatchName.setText(model.getMatchName());
        holder.MTime.setText(model.getMTime());
        holder.MDate.setText(model.getMDate());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView MatchName,MTime,MDate, Status;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            MatchName = itemView.findViewById(R.id.contestname);
            MTime = itemView.findViewById(R.id.timer);
            MDate = itemView.findViewById(R.id.contest_date);
            Status = itemView.findViewById(R.id.contest_status);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position =this.getAdapterPosition();
            FootballClientModel model = mData.get(position);
            String MatchName = model.getMatchName();
            String MTime = model.getMTime();
            String MDate = model.getMDate();
            String Venue = model.getVenue();

            Intent intent = new Intent(context, FC01.class);
            intent.putExtra("MatchName", MatchName);
            intent.putExtra("MDate", MDate);
            intent.putExtra("MTime", MTime);
            intent.putExtra("Venue", Venue);
            intent.putExtra("Id", model.getId());
            context.startActivity(intent);

        }
    }
}
