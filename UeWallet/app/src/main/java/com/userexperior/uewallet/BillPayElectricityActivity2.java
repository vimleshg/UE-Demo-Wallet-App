package com.userexperior.uewallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BillPayElectricityActivity2 extends BaseActivity
{

    Button payNowElectricityBillPayIV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_pay_electricity2);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.top_red_arrow);
        setTitle("Electricity Bill");
        payNowElectricityBillPayIV = (Button) findViewById(R.id.payNowElectricityBillPayIV);
        payNowElectricityBillPayIV.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(BillPayElectricityActivity2.this, BillPayElectricityActivity3.class);
                startActivity(intent);
            }
        });
    }
}
