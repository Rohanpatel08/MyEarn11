package com.example.MyEarn11.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.MyEarn11.Model.ContestListListener;
import com.example.MyEarn11.R;

import java.util.ArrayList;

public class ContestListAdapter extends RecyclerView.Adapter<ContestListAdapter.ViewHolder> {

    View view;
    Context context;
    ArrayList<String> arrayList;
    ContestListListener contestListListener;

    public ContestListAdapter(Context context, ArrayList<String> arrayList, ContestListListener contestListListener) {
        this.context = context;
        this.arrayList = arrayList;
        this.contestListListener = contestListListener;
    }

    @NonNull
    @Override
    public ContestListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.contest_list_item, parent, false);
        return new ViewHolder(view);
    }
    public View getview(){
        return view;
    }

    @Override
    public void onBindViewHolder(@NonNull ContestListAdapter.ViewHolder holder, int position) {
        if (arrayList != null && arrayList.size() > 0){
            holder.checkBox.setText(arrayList.get(position));


            if (holder.checkBox.isChecked()){

            }
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CheckBox checkBox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.check_box);
        }
    }
}
