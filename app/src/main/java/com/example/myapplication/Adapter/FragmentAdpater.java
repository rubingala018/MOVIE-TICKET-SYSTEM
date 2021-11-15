package com.example.myapplication.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication.Fragments.HomeFrag;
import com.example.myapplication.Fragments.ProfileFrag;

public class FragmentAdpater extends FragmentPagerAdapter {
    public FragmentAdpater(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:return new HomeFrag();
            case 1:return new ProfileFrag();
        }
        return new HomeFrag();
    }

    @Override
    public int getCount() {
        return 2;
    }
    public CharSequence getPageTitle(int position) {
        String title= null;
        if(position==0){
            title="HOME";
        }
        if(position==1){

            title="PROFILE";
        }
        return title;
    }
}
