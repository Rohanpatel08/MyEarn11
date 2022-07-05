package com.example.MyEarn11.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.MyEarn11.Model.ContestdetailModel;
import com.example.MyEarn11.R;

import java.util.ArrayList;

public class ContestDetailAdapter extends RecyclerView.Adapter<ContestDetailAdapter.ViewHolder> {

    ArrayList<ContestdetailModel> mList;
    Context context;

    public ContestDetailAdapter(Context context, ArrayList<ContestdetailModel> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ContestDetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contestdetail_card, parent,false);
        return new ContestDetailAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContestDetailAdapter.ViewHolder holder, int position) {
        ContestdetailModel model = mList.get(position);
        holder.MatchName.setText(model.getMatchName());
        holder.MTime.setText(model.getMTime());
        holder.MDate.setText(model.getMDate());
        holder.Venue.setText(model.getVenue());


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView MatchName,MTime,MDate,Venue;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            MatchName = itemView.findViewById(R.id.match_name);
            MTime = itemView.findViewById(R.id.match_time);
            MDate = itemView.findViewById(R.id.match_date);
            Venue = itemView.findViewById(R.id.match_venue);
        }
    }
}
