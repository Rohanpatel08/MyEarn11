package com.example.MyEarn11.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.MyEarn11.CC01;
import com.example.MyEarn11.CC05;
import com.example.MyEarn11.Model.UserModel;
import com.example.MyEarn11.R;

import java.util.ArrayList;

public class UserViewAdapter extends RecyclerView.Adapter <UserViewAdapter.MyViewHolder> {

    ArrayList<UserModel> mLists;
    Context context;


    public UserViewAdapter(Context context, ArrayList<UserModel> mLists) {
        this.mLists = mLists;
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.user_card,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewAdapter.MyViewHolder holder, int position) {
        UserModel ac111ModelContest =mLists.get(position);
        holder.P_mobile.setText(ac111ModelContest.getMobile());
        holder.P_name.setText(ac111ModelContest.getName());
        holder.P_added.setText(ac111ModelContest.getAdd());
        holder.P_holdings.setText(ac111ModelContest.getHolding());
        holder.P_pwd.setText(ac111ModelContest.getPassword());
        holder.P_withdrawed.setText(ac111ModelContest.getWithdrawed());
        holder.P_address.setText(ac111ModelContest.getAddress());
    }

    @Override
    public int getItemCount() {
        return mLists.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView P_mobile,P_name,P_added,P_holdings,P_pwd,P_withdrawed, P_address;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            P_name = itemView.findViewById(R.id.ac112_row_name);
            P_mobile=itemView.findViewById(R.id.ac112_row_phone);
            P_added = itemView.findViewById(R.id.ac112_row_added);
            P_holdings = itemView.findViewById(R.id.ac112_row_holdings);
            P_pwd = itemView.findViewById(R.id.ac112_row_pandl);
            P_withdrawed = itemView.findViewById(R.id.ac112_row_withdrawal);
            P_address = itemView.findViewById(R.id.ac112_row_address);

        }

        @Override
        public void onClick(View v) {
            int position =this.getAdapterPosition();
            UserModel model = mLists.get(position);
            String Name = model.getName();
            String add = model.getAdd();
            String address = model.getAddress();
            String mobile = model.getMobile();
            String password = model.getPassword();
            String holding = model.getHolding();
            String withdrawed = model.getWithdrawed();

            Intent intent = new Intent(context, CC05.class);
            intent.putExtra("name", Name);
            intent.putExtra("add", add);
            intent.putExtra("address", address);
            intent.putExtra("mobile", mobile);
            intent.putExtra("password", password);
            intent.putExtra("holding", holding);
            intent.putExtra("withdrawed", withdrawed);
            context.startActivity(intent);
        }
    }

}
