 package com.example.MyEarn11.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.MyEarn11.CC01;
import com.example.MyEarn11.Model.ClientModel;
import com.example.MyEarn11.R;

import java.util.ArrayList;

public class MyClientViewAdapter extends RecyclerView.Adapter<MyClientViewAdapter.ViewHolder> {

    ArrayList<ClientModel> mData;
    ItemClickListener mClickListener;
    Context context;

    public MyClientViewAdapter(Context context, ArrayList<ClientModel> mData) {
        this.mData = mData;
        this.context = context;
    }

    @NonNull
    @Override
    public MyClientViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.client_card, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyClientViewAdapter.ViewHolder holder, int position) {
        ClientModel model = mData.get(position);
        holder.MatchName.setText(model.getMatchName());
        holder.MTime.setText(model.getMTime());
        holder.MDate.setText(model.getMDate());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);

        boolean onOptionsitemSelected(MenuItem item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView MatchName,MTime,MDate,Status;
        public ViewHolder(View itemview){
            super(itemview);
            itemview.setOnClickListener(this);
            MatchName = itemView.findViewById(R.id.contestname);
            MTime = itemview.findViewById(R.id.timer);
            MDate = itemview.findViewById(R.id.contest_date);
            Status = itemview.findViewById(R.id.contest_status);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position =this.getAdapterPosition();
            ClientModel model = mData.get(position);
            String MatchName = model.getMatchName();
            String MTime = model.getMTime();
            String MDate = model.getMDate();
            String Venue = model.getVenue();

            Intent intent = new Intent(context, CC01.class);
            intent.putExtra("MatchName", MatchName);
            intent.putExtra("MDate", MDate);
            intent.putExtra("MTime", MTime);
            intent.putExtra("Venue", Venue);
            intent.putExtra("Id", model.getId());
            context.startActivity(intent);
        }
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = (ItemClickListener) itemClickListener;
    }

}
