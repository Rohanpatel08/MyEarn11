package com.example.MyEarn11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

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


import com.example.MyEarn11.Adapter.FragmentAdapter;
import com.example.MyEarn11.Adapter.MyClientViewAdapter;
import com.google.android.material.tabs.TabLayout;

public class CC00 extends AppCompatActivity {

    private TabLayout tabLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;
    FragmentAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.viewPager);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout.addTab(tabLayout.newTab().setText("CRICKET"));
        tabLayout.addTab(tabLayout.newTab().setText("FOOTBALL"));
        tabLayout.addTab(tabLayout.newTab().setText("BASKETBALL"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        viewPagerAdapter = new FragmentAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layout,menu);
        for (int i = 0;i<menu.size();i++){
            MenuItem menuItem = menu.getItem(i);
            SpannableString spannable = new SpannableString(menu.getItem(i).getTitle().toString());
            spannable.setSpan(new ForegroundColorSpan(Color.WHITE),0,spannable.length(),0);
            menuItem.setTitle(spannable);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId() ;
        if (id ==R.id.profile){
            Intent intent = new Intent(CC00.this, CC05.class);
            startActivity(intent);
            return true;
        }else if (id == R.id.logout){
            Toast.makeText(getApplicationContext(),"Log Out",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}