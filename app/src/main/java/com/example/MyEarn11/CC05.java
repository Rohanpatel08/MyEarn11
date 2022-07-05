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
import android.widget.TextView;
import android.widget.Toast;

import com.example.MyEarn11.Adapter.UserViewAdapter;
import com.example.MyEarn11.Model.ClientModel;
import com.example.MyEarn11.Model.UserModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CC05 extends AppCompatActivity {

   // private RecyclerView recyclerView;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference root = db.getReference("C_profile");
    //private UserViewAdapter adapter;
    private ArrayList<UserModel> list;
    UserModel model;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        /*Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String add = intent.getStringExtra("add");
        String mobile = intent.getStringExtra("mobile");
        String password = intent.getStringExtra("password");
        String address = intent.getStringExtra("address");
        String holding = intent.getStringExtra("holding");
        String withdrawed = intent.getStringExtra("withdrawed");

        TextView nametxt = findViewById(R.id.ac112_row_name);
        nametxt.setText(name);
        TextView addtxt = findViewById(R.id.ac112_row_added);
        addtxt.setText(add);
        TextView phonetxt = findViewById(R.id.ac112_row_phone);
        phonetxt.setText(mobile);
        TextView passwordtxt = findViewById(R.id.ac112_row_pandl);
        passwordtxt.setText(password);
        TextView addresstxt = findViewById(R.id.ac112_row_address);
        addresstxt.setText(address);
        TextView holdingtxt = findViewById(R.id.ac112_row_holdings);
        holdingtxt.setText(holding);
        TextView withdrawtxt = findViewById(R.id.ac112_row_withdrawal);
        withdrawtxt.setText(withdrawed);*/

        /*recyclerView = findViewById(R.id.ac11_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));*/
        //list= new ArrayList<>();
       // adapter=new UserViewAdapter(this,list);
       // recyclerView.setAdapter(adapter);


       /* root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot :snapshot.getChildren()){
                    UserModel ac111ModelContest =dataSnapshot.getValue(UserModel.class);
                    list.add(ac111ModelContest);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

    }

    public void onResetClick(View view){
        Intent intent = new Intent(CC05.this, CC06.class);
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
            Intent intent = new Intent(CC05.this, CC05.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.logout){
            Toast.makeText(getApplicationContext(),"Log Out",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}
