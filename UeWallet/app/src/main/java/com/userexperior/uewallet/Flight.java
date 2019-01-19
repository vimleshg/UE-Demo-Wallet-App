package com.userexperior.uewallet;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.userexperior.UserExperior;
import com.userexperior.models.recording.enums.UeCustomType;

public class Flight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.arrow), PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationIcon(upArrow);
        toolbar.setTitleTextColor(0xFFFFFFFF);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            UserExperior.setCustomTag("Flight Screen", UeCustomType.EVENT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "Flight Feature coming soon....", Toast.LENGTH_SHORT).show();

        try {
            UserExperior.setCustomTag("Flight Feature coming soon....", UeCustomType.MSG);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onBack(View view) {
        onBackPressed();
    }
}
