package com.userexperior.uewallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class DebitCardHotlistingActivity extends BaseActivity {

    Spinner accountSpinner, debitCardSpinner;
    ImageView proceedIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debit_card_hotlisting);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.top_red_arrow);
        setTitle("Block Card");

        accountSpinner = (Spinner) findViewById(R.id.accountBlockDebitSpinner);
        debitCardSpinner = (Spinner) findViewById(R.id.debitCardSpinner);
        proceedIV = (ImageView) findViewById(R.id.proceedDebitCardBlock);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new String[]{"Select Account", "531123132131 - Saving Account"}); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accountSpinner.setAdapter(spinnerArrayAdapter);

        spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new String[]{"Select Debit Card", "64543533286464656543"}); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        debitCardSpinner.setAdapter(spinnerArrayAdapter);

        proceedIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DebitCardHotlistingActivity.this, DebitCardHotlistingConfirmationActivity.class);
                startActivity(intent);
            }
        });
    }
}
