package com.userexperior.uewallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class BillPayMobilePostPaidActivity2 extends BaseActivity {

    ImageView payNowIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_pay_mobile_post_paid2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.top_red_arrow);
        setTitle("Mobile Bill Pay");
        payNowIV = (ImageView) findViewById(R.id.payNowBillPayMobilePostPaidIV);
        payNowIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BillPayMobilePostPaidActivity2.this, BillPayMobilePostPaidActivity3.class);
                startActivity(intent);
            }
        });
    }
}
