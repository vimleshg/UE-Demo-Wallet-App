package com.userexperior.uewallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AddBeneficiaryActivity extends BaseActivity
{

    ImageView addBeneficiaryIV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_beneficiary);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.top_red_arrow);
        setTitle("Add Beneficiary");

        addBeneficiaryIV = (ImageView) findViewById(R.id.addBeneficiaryIV);
        addBeneficiaryIV.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(AddBeneficiaryActivity.this, AddBeneficiaryConfirmationActivity.class);
                startActivity(intent);
            }
        });
    }
}
