package com.example.MyEarn11.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.MyEarn11.basketball_fragment;
import com.example.MyEarn11.cricket_fragment;
import com.example.MyEarn11.football_fragment;

public class FragmentAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    public FragmentAdapter(FragmentManager fragmentManager, int CountTabs){
        super(fragmentManager);
        this.tabCount = CountTabs;

    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new cricket_fragment();
            case 1:
                return new football_fragment();
            case 2:
                return new basketball_fragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
