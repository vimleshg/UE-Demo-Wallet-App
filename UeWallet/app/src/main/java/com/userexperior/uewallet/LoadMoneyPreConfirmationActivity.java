package com.userexperior.uewallet;

import android.os.Bundle;
import android.widget.ImageView;

public class LoadMoneyPreConfirmationActivity extends BaseActivity {

    ImageView transferNowIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_money_pre_confirmation);

        getSupportActionBar().setTitle("Load Money");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.top_red_arrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
