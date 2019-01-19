package com.userexperior.uewallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


import com.userexperior.utilities.SecureViewBucket;

//import main.java.com.mindscapehq.android.raygun4android.RaygunClient;

public class BillPayMobilePostPaidActivity1 extends BaseActivity
{

    Spinner circleSpinner, serviceProviderSpinner;
    View proceedIV;

    EditText mobnum, amtET;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_pay_mobile_post_paid1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.top_red_arrow);
        setTitle("Mobile Bill Pay");
        circleSpinner = (Spinner) findViewById(R.id.circleMobilePostPaidSpinner);
        serviceProviderSpinner = (Spinner) findViewById(R.id.serviceProviderMobilePostPaidSpinner);
        proceedIV = findViewById(R.id.proceedBillPayMobilePostPaidIV);
        proceedIV.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int div = 1 / 0; // app crash
                Intent intent = new Intent(BillPayMobilePostPaidActivity1.this, BillPayMobilePostPaidActivity2.class);
                startActivity(intent);
            }
        });

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new String[]{"Service Provider", "Airtel", "Idea", "Vodafone"}); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        serviceProviderSpinner.setAdapter(spinnerArrayAdapter);

        spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new String[]{"Circle", "Mumbai", "Thane"}); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        circleSpinner.setAdapter(spinnerArrayAdapter);

        mobnum = (EditText) findViewById(R.id.mobnum);
        amtET = (EditText) findViewById(R.id.amtET);

        SecureViewBucket.addInSecureViewBucket(mobnum);
        SecureViewBucket.addInSecureViewBucket(amtET);
    }
}
