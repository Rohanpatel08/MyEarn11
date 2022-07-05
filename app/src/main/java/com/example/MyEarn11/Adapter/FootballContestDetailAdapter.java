package com.example.MyEarn11.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.MyEarn11.Model.ContestdetailModel;
import com.example.MyEarn11.Model.FootballContestDetailModel;
import com.example.MyEarn11.R;

import java.util.ArrayList;

public class FootballContestDetailAdapter extends RecyclerView.Adapter<FootballContestDetailAdapter.ViewHolder> {

    ArrayList<FootballContestDetailModel> mList;
    Context context;

    public FootballContestDetailAdapter(Context context,ArrayList<FootballContestDetailModel> mList) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public FootballContestDetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contestdetail_card, parent,false);
        return new FootballContestDetailAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FootballContestDetailModel model = mList.get(position);
        holder.MatchName.setText(model.getMatchName());
        holder.MTime.setText(model.getMTime());
        holder.MDate.setText(model.getMDate());
        holder.Venue.setText(model.getVenue());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

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
