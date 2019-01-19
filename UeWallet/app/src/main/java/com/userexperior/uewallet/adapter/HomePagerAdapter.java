package com.userexperior.uewallet.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.userexperior.uewallet.fragment.HomeAccountCardFragment;
import com.userexperior.uewallet.fragment.HomeWalletCardFragment;

public class HomePagerAdapter extends FragmentPagerAdapter
{
    public static final int POSITION_ACCOUNT = 1;
    public static final int POSITION_WALLET = 0;

    public static final int COUNT = 2;

    public HomePagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case POSITION_ACCOUNT:
                return HomeAccountCardFragment.newInstance();
            case POSITION_WALLET:
                return HomeWalletCardFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount()
    {
        return COUNT;
    }
}
