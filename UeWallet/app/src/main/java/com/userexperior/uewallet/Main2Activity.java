package com.userexperior.uewallet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.userexperior.UserExperior;
import com.userexperior.models.recording.enums.UeCustomType;

public class Main2Activity extends AppCompatActivity {

    private TextView mTextMessage;
    private Button navBtn;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    try {
                        UserExperior.startScreen("Home Tab");

                        UserExperior.setCustomTag("Pass your app message/any error message here here", UeCustomType.MSG);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    try {
                        UserExperior.startScreen("Dashboard Tab");

                        UserExperior.setCustomTag("Pass your app message/any error message here here", UeCustomType.MSG);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    try {
                        UserExperior.startScreen("Notification Tab");

                        UserExperior.setCustomTag("Notification", UeCustomType.EVENT);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mTextMessage = (TextView) findViewById(R.id.message);
        navBtn = (Button) findViewById(R.id.navBtn);


        mTextMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // to crash the app
                int i = 1 / 0;
            }
        });

        navBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // for testing api screen name going proper while anr event
                int i = 0;
                while(true){
                    i++; // to produce anr on the app
                }
            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
