package com.userexperior.uewallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.userexperior.UserExperior;

public class LoadMoneyActivity extends BaseActivity
{

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_money);

        getSupportActionBar().setTitle("Load Money");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.top_red_arrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(LoadMoneyActivity.this, LoadMoneyPreConfirmationActivity.class);
                startActivity(intent);
            }
        });



    }

    @Override
    protected void onResume() {
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        super.onResume();

        try {
            UserExperior.endTimer("Time taken to Load Money");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
