package com.userexperior.uewallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ManageBeneficiaryActivity1 extends AppCompatActivity {

    ImageView addNewIV, statementIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_beneficiary_1);

        addNewIV = (ImageView) findViewById(R.id.addNewBeneIV2);
        statementIV = (ImageView) findViewById(R.id.statementBeneIV2);

        addNewIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManageBeneficiaryActivity1.this, AddBeneficiaryActivity.class);
                startActivity(intent);
            }
        });
    }
}
