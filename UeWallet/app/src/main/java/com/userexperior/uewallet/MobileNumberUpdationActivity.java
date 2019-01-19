package com.userexperior.uewallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MobileNumberUpdationActivity extends BaseActivity
{

    ImageView proceedIV;
    Spinner accountSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_number_updation);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.top_red_arrow);
        setTitle("Mobile Number Updation");

        proceedIV = (ImageView) findViewById(R.id.proceedMobileNumUpdationIV);
        proceedIV.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MobileNumberUpdationActivity.this, MobileNumberUpdationConfirmationActivity.class);
                startActivity(intent);
            }
        });

        accountSpinner = (Spinner) findViewById(R.id.accountSpinner);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new String[]{"Select Account", "452050127951 - Saving Account"}); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accountSpinner.setAdapter(spinnerArrayAdapter);
    }
}
