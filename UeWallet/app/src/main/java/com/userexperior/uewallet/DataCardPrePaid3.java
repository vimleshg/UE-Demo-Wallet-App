package com.userexperior.uewallet;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DataCardPrePaid3 extends AppCompatActivity {

    private ViewPager mViewPager;
    private PagerAdapter mSectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_card_pre_paid3);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.arrow), PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationIcon(upArrow);
        toolbar.setTitleTextColor(0xFFFFFFFF);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        PagerTabStrip pagerTabStrip = (PagerTabStrip) findViewById(R.id.pager_tab_strip);
        pagerTabStrip.setTabIndicatorColor(Color.RED);

        mViewPager = (ViewPager)findViewById(R.id.pager);
        mSectionsPagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }


            @Override
            public CharSequence getPageTitle(int position) {

                String title = "";

                switch (position){
                    case 0:
                        title =  "2G";
                    break;

                    case 1:
                        title =  "3G";
                    break;

                    case 2:
                        title =  "4G";
                    break;


                }

                return title;
            }


            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                LayoutInflater inflater = LayoutInflater.from(getBaseContext());
                ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.viewpager_data_card_pre_paid3, container, false);
                container.addView(layout);
                return layout;
            }
        };
        mViewPager.setAdapter(mSectionsPagerAdapter);


    }

    public void goToPrePid4(View view) {
        startActivity(new Intent(this,DataCardPrePaid4.class));
    }
}
