package com.userexperior.uewallet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.userexperior.uewallet.utils.IntentUtils;

public class BillPayElectricityActivity3 extends BaseActivity
{

    Button goToHomeIV, anotherBillPayIV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_pay_electricity3);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.top_red_arrow);
        setTitle("Electricity Bill");
        goToHomeIV = (Button) findViewById(R.id.goToHomeBillPayElectricityIV);
        anotherBillPayIV = (Button) findViewById(R.id.anotherBillPayBillPayElectricityIV);

        anotherBillPayIV.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                IntentUtils.startElectricity(BillPayElectricityActivity3.this);
            }
        });

        goToHomeIV.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                IntentUtils.startHome(BillPayElectricityActivity3.this);
            }
        });
    }
}
