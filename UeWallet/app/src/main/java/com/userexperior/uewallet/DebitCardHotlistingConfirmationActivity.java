package com.userexperior.uewallet;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.userexperior.uewallet.utils.IntentUtils;

public class DebitCardHotlistingConfirmationActivity extends BaseActivity
{

    ImageView goToHomeIV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debit_card_hotlisting_confirmation);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.top_red_arrow);
        setTitle("Block Card");

        goToHomeIV = (ImageView) findViewById(R.id.goToHomeDebitCardBlockIV);

        goToHomeIV.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                IntentUtils.startHome(DebitCardHotlistingConfirmationActivity.this);
            }
        });
    }
}
