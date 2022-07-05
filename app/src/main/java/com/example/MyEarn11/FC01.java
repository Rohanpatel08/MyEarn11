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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.MyEarn11.Adapter.FootballContestDetailAdapter;
import com.example.MyEarn11.Model.FootballContestDetailModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FC01 extends AppCompatActivity {

    //private RecyclerView CC01_recyclerView;
    private DatabaseReference root = FirebaseDatabase.getInstance().getReference("AF_matches&Score&contest");
    //private FootballContestDetailAdapter CC01_adapter;
    //private ArrayList<FootballContestDetailModel> CC01_list;

    TextView name_text, date_text, time_text, venue_text;
    Button create_team, contests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football_contest_details);

        Intent intent = getIntent();
        String mname = intent.getStringExtra("MatchName");
        String mtime = intent.getStringExtra("MTime");
        String mdate = intent.getStringExtra("MDate");
        String venue = intent.getStringExtra("Venue");
        String value = intent.getStringExtra("Id");
        System.out.println("MatchId : "+value);

        TextView Mnametxt = findViewById(R.id.Fmatch_name);
        Mnametxt.setText(mname);
        TextView Mtimetxt = findViewById(R.id.Fmatch_time);
        Mtimetxt.setText(mtime);
        TextView Mdatetxt = findViewById(R.id.Fmatch_date);
        Mdatetxt.setText(mdate);
        TextView Venue = findViewById(R.id.Fmatch_venue);
        Venue.setText(venue);

        name_text = findViewById(R.id.name_text);
        date_text = findViewById(R.id.date_text);
        time_text = findViewById(R.id.time_text);
        venue_text = findViewById(R.id.venue_text);
        create_team = findViewById(R.id.Fcreateteam_btn);
        contests = findViewById(R.id.Fcontests_btn);

        /*CC01_recyclerView = findViewById(R.id.recyclerviewcontest);
        CC01_recyclerView.setHasFixedSize(true);
        CC01_recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CC01_list = new ArrayList<>();
        CC01_adapter = new FootballContestDetailAdapter(this,CC01_list);*/


        //CC01_recyclerView.setAdapter(CC01_adapter);

        /*root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    if(!(String.valueOf(dataSnapshot.getKey()).equals("Counter")))
                    {
                        FootballContestDetailModel model = dataSnapshot.getValue(FootballContestDetailModel.class);
                        CC01_list.add(model);
                    }
                    else
                    {
                        break;
                    }
                    /*ContestdetailModel model = dataSnapshot.getValue(ContestdetailModel.class);

                    CC01_list.add(model);
                }
                CC01_adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    public void onContestsClick(View view){
        Intent intent = new Intent(FC01.this, FC02.class);
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
        int id =item.getItemId() ;
        if (id ==R.id.profile){
            Intent intent = new Intent(FC01.this, CC05.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.logout){
            Toast.makeText(getApplicationContext(),"Log Out",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}