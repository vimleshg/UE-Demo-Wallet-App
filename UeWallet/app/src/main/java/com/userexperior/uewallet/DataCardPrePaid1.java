package com.userexperior.uewallet;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.userexperior.UserExperior;
import com.userexperior.models.recording.enums.UeCustomType;

public class DataCardPrePaid1 extends AppCompatActivity
{

    Spinner circleSpinner, serviceProviderSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_card_prepaid_1);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.arrow), PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationIcon(upArrow);
        toolbar.setTitleTextColor(0xFFFFFFFF);
        toolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onBackPressed();
            }
        });

        circleSpinner = (Spinner) findViewById(R.id.circleSpinner);
        serviceProviderSpinner = (Spinner) findViewById(R.id.serviceProviderSpinner);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new String[]{"Service Provider", "Vodafone", "Airtle"}); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        serviceProviderSpinner.setAdapter(spinnerArrayAdapter);
        spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new String[]{"Circle", "Mumbai", "Thane"}); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        circleSpinner.setAdapter(spinnerArrayAdapter);
    }

    public void goToPrePid2(View view) {
        startActivity(new Intent(this, DatacardPrePaid2.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            UserExperior.setCustomTag("Mobile Top-up Tag", UeCustomType.EVENT);
            //UserExperior.setCustomTag("Mobile Top-up Tag");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "Mobile Top-up selected", Toast.LENGTH_SHORT).show();

        try {
            UserExperior.setCustomTag("Mobile Top-up selected", UeCustomType.MSG);
            //UserExperior.setCustomTag("Mobile Top-up selected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
