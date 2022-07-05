package com.example.MyEarn11;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.MyEarn11.Adapter.FootballClientViewAdapter;
import com.example.MyEarn11.Model.FootballClientModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */

public class football_fragment extends Fragment {

    private RecyclerView CC00_recyclerView;
    private DatabaseReference root = FirebaseDatabase.getInstance().getReference("AF_matches&Score&contest");
    private FootballClientViewAdapter CC00_adapter;
    private ArrayList<FootballClientModel> CC00_list;

    public football_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_football_fragment, container, false);

        CC00_recyclerView = view.findViewById(R.id.recyclerviewclientfootball);
        CC00_recyclerView.setHasFixedSize(true);
        CC00_recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CC00_list = new ArrayList<>();
        CC00_adapter = new FootballClientViewAdapter(getContext(),CC00_list);

        CC00_recyclerView.setAdapter(CC00_adapter);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    if(!(String.valueOf(dataSnapshot.getKey()).equals("Counter")))
                    {
                        //dataSnapshot.getKey();
                        FootballClientModel model = dataSnapshot.getValue(FootballClientModel.class);
                        model.setId(dataSnapshot.getKey());
                        for (DataSnapshot ds : dataSnapshot.getChildren()){
                            if (ds.getKey().equals("Status")){
                                String status = ds.getValue().toString();
                                if (status.equals("Ongoing")){
                                    System.out.println("Rohan 1");
                                    //FootballClientModel model = dataSnapshot.getValue(FootballClientModel.class);
                                    CC00_list.add(model);
                                }else if (status.equals("NULL")){
                                    System.out.println("Rohan 2");
                                    //FootballClientModel model = dataSnapshot.getValue(FootballClientModel.class);
                                    CC00_list.add(model);
                                }else {

                                    System.out.println("Rohan 3");
                                    //FootballClientModel model = dataSnapshot.getValue(FootballClientModel.class);
                                    CC00_list.remove(model);
                                }
                            }
                        }

                    }
                    else
                    {
                        break;
                    }
                    /*ClientModel model = dataSnapshot.getValue(ClientModel.class);

                    CC00_list.add(model);*/
                }
                CC00_adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return view;
    }

}