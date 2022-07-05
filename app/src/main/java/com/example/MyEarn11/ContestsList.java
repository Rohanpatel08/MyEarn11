package com.example.MyEarn11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.MyEarn11.Adapter.ContestListAdapter;
import com.example.MyEarn11.Model.ContestListListener;

import java.util.ArrayList;

public class ContestsList extends AppCompatActivity implements ContestListListener {

    RecyclerView recyclerView;
    ContestListAdapter contestListAdapter;
    Button addbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contests_list);

        recyclerView = findViewById(R.id.recyclerviewcontestlist);
        addbtn = findViewById(R.id.add_btn);
        setRecyclerView();

    }

    private ArrayList<String> getQuantityData(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("10 kg");
        arrayList.add("20 kg");
        arrayList.add("30 kg");
        arrayList.add("40 kg");
        arrayList.add("50 kg");
        arrayList.add("60 kg");
        arrayList.add("70 kg");
        arrayList.add("80 kg");
        arrayList.add("90 kg");
        arrayList.add("100 kg");
        arrayList.add("110 kg");

        return arrayList;
    }

    private void setRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        contestListAdapter = new ContestListAdapter(this,getQuantityData(),this);
        recyclerView.setAdapter(contestListAdapter);
    }

    @Override
    public void onQuantityChange(ArrayList<String> arrayList) {

    }
}