package com.gilbertopapa.shareimage.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.gilbertopapa.shareimage.fragment.HomeFragment;
import com.gilbertopapa.shareimage.fragment.UserFragment;

/**
 * Created by GilbertoPapa on 21/08/2018.
 */

public class TabAdapter extends FragmentStatePagerAdapter {

    private Context context;
    private String[] titleAbs = {"HOME", "CONTATOS"};

    public TabAdapter(FragmentManager fm, Context c) {
        super(fm);
        this.context = c;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new UserFragment();
        }

        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return titleAbs[position];
    }

    @Override
    public int getCount() {
        return titleAbs.length;
    }
}
