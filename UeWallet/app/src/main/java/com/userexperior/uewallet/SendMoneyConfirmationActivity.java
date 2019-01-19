package com.userexperior.uewallet;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

public class SendMoneyConfirmationActivity extends BaseActivity
{
    private Toolbar mToolBarActionbar;

    private TextView name;
    private TextView type;
    private TextView info;
    private Button button;

    private String mType;
    private String mName;
    private String mInfo;
    private boolean mNewBeneficiary;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_money_confirmation);

        Bundle extras = getIntent().getExtras();
        if (extras != null)
        {
            mName = extras.getString("name");
            mType = extras.getString("type");
            mInfo = extras.getString("info");
            mNewBeneficiary = extras.getBoolean("new_beneficiary");
        }

        name = (TextView) findViewById(R.id.name);
        type = (TextView) findViewById(R.id.typeText);
        info = (TextView) findViewById(R.id.info);

        if (!TextUtils.isEmpty(mType))
        {
            type.setText("Transfer Type: " + mType);
        }

        if (!TextUtils.isEmpty(mInfo))
        {
            info.setText(mInfo);
        }

        if (!TextUtils.isEmpty(mName))
        {
            name.setText(mName);
        }


        mToolBarActionbar = (Toolbar) findViewById(R.id.toolbarActionbar);
        setSupportActionBar(mToolBarActionbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.top_red_arrow);
        getSupportActionBar().setTitle("Send Money");
    }
}
