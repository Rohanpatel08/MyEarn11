package com.example.MyEarn11.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.MyEarn11.Model.FootballContestModel;
import com.example.MyEarn11.R;

import java.util.ArrayList;

public class FootballContestViewAdapter extends RecyclerView.Adapter<FootballContestViewAdapter.ViewHolder>{

    ArrayList<FootballContestModel> mList;
    Context context;

    public FootballContestViewAdapter(Context context, ArrayList<FootballContestModel> mList) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public FootballContestViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contest_card, parent,false);
        return new FootballContestViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FootballContestViewAdapter.ViewHolder holder, int position) {
        FootballContestModel model = mList.get(position);
        holder.Name.setText(model.getName());
        holder.MinimumPlayer.setText(model.getMinimumPlayer());
        holder.MaximumPlayer.setText(model.getMaximumPlayer());
        holder.WinningAmount.setText(model.getWinningAmount());
        holder.Type.setText(model.getType());
        holder.JoiningAmount.setText(model.getJoiningAmount());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView Name, MaximumPlayer,MinimumPlayer, WinningAmount,Type;
        Button JoiningAmount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.contest_name);
            MaximumPlayer = itemView.findViewById(R.id.maximumplayers);
            MinimumPlayer = itemView.findViewById(R.id.minimumplayers);
            WinningAmount = itemView.findViewById(R.id.winning_amount);
            Type = itemView.findViewById(R.id.type);
            JoiningAmount = itemView.findViewById(R.id.JoinningAmount);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
