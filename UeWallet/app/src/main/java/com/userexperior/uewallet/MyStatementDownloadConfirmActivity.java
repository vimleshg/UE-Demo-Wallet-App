package com.userexperior.uewallet;

import android.os.Bundle;
import android.view.View;

import com.userexperior.uewallet.utils.IntentUtils;

public class MyStatementDownloadConfirmActivity extends BaseActivity
{

    View home;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_statement_download_confirm);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.top_red_arrow);
        setTitle("My Statement");

        home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                IntentUtils.startHome(MyStatementDownloadConfirmActivity.this);
            }
        });
    }
}
