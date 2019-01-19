package com.userexperior.uewallet;

import android.os.Bundle;
import android.view.View;

import com.userexperior.uewallet.utils.IntentUtils;
import com.userexperior.UserExperior;

public class DataCardPrePaid4 extends BaseActivity
{

    View home;
    View tryAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_card_pre_paid4);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.top_red_arrow);
        setTitle("Mobile Top-up");

        home = findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                IntentUtils.startHome(DataCardPrePaid4.this);
                //UserExperior.resumeRecording();
            }
        });

        tryAgain = findViewById(R.id.btn_try_again);
        tryAgain.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                IntentUtils.startPrepaid(DataCardPrePaid4.this);
            }
        });
    }
}
