package com.userexperior.uewallet;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.userexperior.uewallet.utils.IntentUtils;

public class BillPayMobilePostPaidActivity3 extends BaseActivity
{

    ImageView goToHomeIV, anotherBillPayIV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_pay_mobile_post_paid3);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.top_red_arrow);
        setTitle("Mobile Bill Pay");
        goToHomeIV = (ImageView) findViewById(R.id.goToHomeMobilePostPaidIV);
        anotherBillPayIV = (ImageView) findViewById(R.id.anotherBillPayMobilePostPaidIV);

        goToHomeIV.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                IntentUtils.startHome(BillPayMobilePostPaidActivity3.this);
            }
        });

        anotherBillPayIV.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                IntentUtils.startPostpaid(BillPayMobilePostPaidActivity3.this);
            }
        });
    }
}
