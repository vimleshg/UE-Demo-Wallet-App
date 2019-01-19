package com.userexperior.uewallet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.userexperior.UserExperior;
import com.userexperior.models.recording.enums.UeCustomType;

public class BillPayElectricityActivity1 extends BaseActivity
{

    Button proceedElectricityBillPayIV;
    Spinner citySpinner, electricityBoardSpinner;

    EditText consumeET;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_pay_electricity1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.top_red_arrow);
        setTitle("Electricity Bill");
        citySpinner = (Spinner) findViewById(R.id.citySpinner);
        electricityBoardSpinner = (Spinner) findViewById(R.id.electricityBoardSpinner);

        proceedElectricityBillPayIV = (Button) findViewById(R.id.proceedElectricityBillPayIV);
        proceedElectricityBillPayIV.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(BillPayElectricityActivity1.this, BillPayElectricityActivity2.class);
                startActivity(intent);
            }
        });

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new String[]{"Electricity Board", "Maha Vitran", "MSEB"}); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        electricityBoardSpinner.setAdapter(spinnerArrayAdapter);

        spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, new String[]{"City", "Mumbai", "Thane", "Pune"}); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(spinnerArrayAdapter);

        consumeET = (EditText) findViewById(R.id.editText3);
        consumeET.setTag("uesdk__secure_view");

    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            UserExperior.setCustomTag("Electricity", UeCustomType.EVENT);
            //UserExperior.setCustomTag("Electricity");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "Electricity Payment selected", Toast.LENGTH_SHORT).show();

        try {
            UserExperior.setCustomTag("Electricity Payment selected", UeCustomType.MSG);
            //UserExperior.setCustomTag("Electricity Payment selected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
