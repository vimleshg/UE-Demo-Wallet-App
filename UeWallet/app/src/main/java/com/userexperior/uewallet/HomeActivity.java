package com.userexperior.uewallet;

import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.userexperior.uewallet.adapter.HomeAdapter;
import com.userexperior.uewallet.adapter.HomePagerAdapter;

public class HomeActivity extends AppCompatActivity
{
    private Toolbar mToolBarActionbar;
    private ViewPager mViewPager;
    private RecyclerView mRecyclerView;


    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mDrawerToggle;

    private TextView mTitleText;
    private ImageView leftArrow;
    private ImageView rightArrow;

    private View myAccount;
    private View mStatement;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mToolBarActionbar = (Toolbar) findViewById(R.id.toolbarActionbar);
        setSupportActionBar(mToolBarActionbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setTitle("");

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.navigationView);

        mTitleText = (TextView) findViewById(R.id.title);
        mTitleText.setText("UE Demo");
        //leftArrow = (ImageView) findViewById(R.id.left_arrow);
        //leftArrow.setColorFilter(Color.DKGRAY);
        //rightArrow = (ImageView) findViewById(R.id.right_arrow);
        //rightArrow.setColorFilter(Color.WHITE);

        setUpDrawer();
        setUpViewPager();
        setUpRecyclerView();
        setUpNavigationIcons();

        /*leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(0, false);
            }
        });

        rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(1, false);
            }
        });*/
    }

    private void setUpNavigationIcons()
    {
        /*myAccount = findViewById(R.id.my_account);
        myAccount.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                IntentUtils.startMyAccount(HomeActivity.this);
            }
        });

        mStatement = findViewById(R.id.statement);
        mStatement.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                IntentUtils.startStatement(HomeActivity.this, false);
            }
        });*/
    }

    private void setUpRecyclerView()
    {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewHome);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new HomeAdapter(this));
    }

    private void setUpViewPager()
    {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        HomePagerAdapter pagerAdapter = new HomePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {

            }

            @Override
            public void onPageSelected(int position)
            {
                /*leftArrow.setColorFilter(Color.WHITE);
                if (position == HomePagerAdapter.POSITION_WALLET)
                {
                    leftArrow.setColorFilter(Color.DKGRAY);
                    mTitleText.setText("UE Pay");
                }
                if (position == HomePagerAdapter.POSITION_ACCOUNT)
                {
                    mTitleText.setText("UE Bank");
                }*/
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });
    }

    private void setUpDrawer()
    {

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                mToolBarActionbar,  /* nav drawer icon to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        )
        {
            public void onDrawerClosed(View view)
            {
                super.onDrawerClosed(view);
            }

            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
            }
        };

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

}
