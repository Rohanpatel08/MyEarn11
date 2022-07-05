package com.example.MyEarn11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.MyEarn11.Adapter.ContestViewAdapter;
import com.example.MyEarn11.Adapter.FootballContestViewAdapter;
import com.example.MyEarn11.Model.FootballContestModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FC02 extends AppCompatActivity implements ContestViewAdapter.ItemClickListener {

    private RecyclerView CC01_recyclerView;
    private DatabaseReference root = FirebaseDatabase.getInstance().getReference("AF_contest");
    private FootballContestViewAdapter CC01_adapter;
    private ArrayList<FootballContestModel> CC01_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football_contest_property);

        CC01_recyclerView = findViewById(R.id.footballcontest);
        CC01_recyclerView.setHasFixedSize(true);
        CC01_recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CC01_list = new ArrayList<>();
        CC01_adapter = new FootballContestViewAdapter(this,CC01_list);

        CC01_recyclerView.setAdapter(CC01_adapter);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    if(!(String.valueOf(dataSnapshot.getKey()).equals("Counter")))
                    {
                        FootballContestModel model = dataSnapshot.getValue(FootballContestModel.class);
                        CC01_list.add(model);
                    }
                    else
                    {
                        break;
                    }
                    /*ContestModel model = dataSnapshot.getValue(ContestModel.class);

                    CC01_list.add(model);*/
                }
                CC01_adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void onTeamClick(View view) {
        Intent intent = new Intent(FC02.this, FC03.class);
        startActivity(intent);

    }

    public void onContestClick(View view) {
        Intent intent = new Intent(FC02.this, FC04.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layout,menu);
        for (int i = 0;i<menu.size();i++){
            MenuItem menuItem = menu.getItem(i);
            SpannableString spannable = new SpannableString(menu.getItem(i).getTitle().toString());
            spannable.setSpan(new ForegroundColorSpan(Color.BLACK),0,spannable.length(),0);
            menuItem.setTitle(spannable);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();
        if (id ==R.id.profile){
            Intent intent = new Intent(FC02.this, CC05.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.logout){
            Toast.makeText(getApplicationContext(),"Log Out",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(View view, int position) {

    }

    @Override
    public boolean onOptionsitemSelected(MenuItem item) {
        return false;
    }
}