package com.example.hangi.fufa.ViewHolders;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by hangi on 3/28/18.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {


    private final List<Fragment>lsFragment=new ArrayList<>();

    private final List<String>lsTitle=new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return lsFragment.get(position);
    }

    @Override
    public int getCount() {
        return lsTitle.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return lsTitle.get(position);
    }


    public void AddFragment(Fragment fragment,String title){

        lsFragment.add(fragment);
        lsTitle.add(title);
    }



}
