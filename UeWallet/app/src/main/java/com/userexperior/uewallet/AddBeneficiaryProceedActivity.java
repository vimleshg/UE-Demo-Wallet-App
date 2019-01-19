package com.userexperior.uewallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AddBeneficiaryProceedActivity extends AppCompatActivity {

    ImageView proceedIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_beneficiary_proceed);

        proceedIV = (ImageView) findViewById(R.id.proceedAddBeneConfirmationIV);
        proceedIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddBeneficiaryProceedActivity.this, AddBeneficiaryConfirmationActivity.class);
                startActivity(intent);
            }
        });
    }
}
