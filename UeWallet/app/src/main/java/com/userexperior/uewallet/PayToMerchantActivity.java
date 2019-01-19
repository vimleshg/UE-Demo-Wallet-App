package com.userexperior.uewallet;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.userexperior.uewallet.fragment.MobileFragment;
import com.userexperior.UserExperior;
import com.userexperior.models.recording.enums.UeCustomType;
import com.userexperior.uewallet.fragment.QrCodeFragment;

public class PayToMerchantActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private PayFragmentAdapter mSectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_to_merchant);

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

        TabLayout tabLayout = (TabLayout) findViewById(R.id.pager_tab_strip);

        tabLayout.setTabTextColors(Color.LTGRAY, Color.WHITE);

        mViewPager = (ViewPager)findViewById(R.id.pager);
        tabLayout.setupWithViewPager(mViewPager);
        mViewPager.setAdapter(new PayFragmentAdapter(getSupportFragmentManager()));
        mViewPager.setCurrentItem(1);


    }

    class PayFragmentAdapter extends FragmentPagerAdapter {

        public PayFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return QrCodeFragment.newInstance();

                case 1:
                    return MobileFragment.newInstance();

                default:
                    return null;
            }


        }

        @Override
        public CharSequence getPageTitle(int position) {

            String title = "";

            switch (position){
                case 0:
                    title =  "Scan Code";
                    break;

                case 1:
                    title =  "Mobile";
                    break;


            }

            return title;
        }

        @Override
        public int getCount() {
            // return CONTENT.length;
            return 2;
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            UserExperior.setCustomTag("Pay To Merchant Tag", UeCustomType.EVENT);
            //UserExperior.setCustomTag("Pay To Merchant Tag");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "Pay to Merchat selected", Toast.LENGTH_SHORT).show();

        try {
            UserExperior.setCustomTag("Pay to Merchat selected", UeCustomType.MSG);
            //UserExperior.setCustomTag("Pay to Merchat selected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
