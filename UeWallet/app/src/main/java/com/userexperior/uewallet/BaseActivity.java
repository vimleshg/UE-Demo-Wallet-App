package com.userexperior.uewallet;

import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public abstract class BaseActivity extends AppCompatActivity
{
    public static final int PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;
    public static final int PERMISSIONS_REQUEST_CAMERA = 2;
    protected int mContainerID;
    protected int mFragEnterAnim, mFragExitAnim, mFragPopEnterAnim, mFragPopExitAnim;

    @Override
    public void setContentView(@LayoutRes int layoutResID)
    {
        super.setContentView(layoutResID);
        mContainerID = R.id.container;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == android.R.id.home)
        {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    protected void addFragment(Fragment fragment, String tag)
    {
        addFragment(fragment, tag, false,
                mFragEnterAnim, mFragExitAnim, mFragPopEnterAnim, mFragPopExitAnim);
    }

    protected void replaceFragment(Fragment fragment, String tag)
    {
        replaceFragment(fragment, tag, false,
                mFragEnterAnim, mFragExitAnim, mFragPopEnterAnim, mFragPopExitAnim);
    }

    protected void replaceFragment(Fragment fragment, String tag, int containerID)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction()
                .replace(containerID, fragment, tag);
        transaction.commit();
    }

    protected void addFragment(Fragment fragment, String tag, boolean addToBackStack)
    {
        addFragment(fragment, tag, addToBackStack,
                mFragEnterAnim, mFragExitAnim, mFragPopEnterAnim, mFragPopExitAnim);
    }

    protected void replaceFragment(Fragment fragment, String tag, boolean addToBackStack)
    {
        replaceFragment(fragment, tag, addToBackStack,
                mFragEnterAnim, mFragExitAnim, mFragPopEnterAnim, mFragPopExitAnim);
    }

    protected void addFragment(Fragment fragment, String tag, boolean addToBackStack,
                               int enterAnim, int exitAnim, int popEnterAnim, int popExitAnim)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim)
                .add(mContainerID, fragment, tag);

        if (addToBackStack) transaction.addToBackStack(tag);
        transaction.commit();
    }

    protected void replaceFragment(Fragment fragment, String tag, boolean addToBackStack,
                                   int enterAnim, int exitAnim, int popEnterAnim, int popExitAnim)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim)
                .replace(mContainerID, fragment, tag);

        if (addToBackStack) transaction.addToBackStack(tag);
        transaction.commit();
    }
}
