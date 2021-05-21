package com.example.zeroset.search.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.zeroset.search.ui.searchResultcontentFragment;
import com.example.zeroset.search.ui.searchResultproductFragment;
import com.example.zeroset.search.ui.searchResultshopFragment;
import com.example.zeroset.search.ui.searchResulttotalFragment;

public class SearchPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;


    public SearchPagerAdapter(@NonNull FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: {
                return new searchResulttotalFragment();
            }
            case 1: {
                return new searchResultproductFragment();
            }
            case 2: {
                return new searchResultshopFragment();
            }
            case 3: {
                return new searchResultcontentFragment();
            }

            default: {
                return null;

            }
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
