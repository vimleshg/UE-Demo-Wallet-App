package com.userexperior.uewallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class EmailIDRegistrationActivity extends BaseActivity
{

    ImageView proceedIV;
    Spinner accountSpinner, frequencySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_idregistration);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.top_red_arrow);
        setTitle("Email ID Registration");

        proceedIV = (ImageView) findViewById(R.id.proceedEmailRegIV);
        accountSpinner = (Spinner) findViewById(R.id.accountEmailRegSpinner);
        frequencySpinner = (Spinner) findViewById(R.id.frequencySpinner);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new String[]{"Select Account", "5651321321323 - Saving Account"}); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accountSpinner.setAdapter(spinnerArrayAdapter);

        spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new String[]{"Select Frequency", "Quaterly"}); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        frequencySpinner.setAdapter(spinnerArrayAdapter);

        proceedIV.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(EmailIDRegistrationActivity.this, EmailIDRegistrationConfirmationActivity.class);
                startActivity(intent);
            }
        });
    }
}
