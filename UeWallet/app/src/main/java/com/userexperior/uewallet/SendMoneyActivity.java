package com.userexperior.uewallet;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.userexperior.uewallet.fragment.SendMoneyFragment;

public class SendMoneyActivity extends BaseActivity
{
    private Toolbar mToolBarActionbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money);

        mToolBarActionbar = (Toolbar) findViewById(R.id.toolbarActionbar);
        setSupportActionBar(mToolBarActionbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.top_red_arrow);
        getSupportActionBar().setTitle("Send Money");

        replaceFragment(new SendMoneyFragment(), SendMoneyFragment.TAG);
    }
}
