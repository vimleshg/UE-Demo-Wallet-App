package com.userexperior.uewallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.userexperior.UserExperior;
import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity
{

    private Button loginBtn;
    private EditText mPinET;
    private String mPin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setTitle("Login");

        try {
            // 19.154691, 72.940880 == workloft 19.154023, 72.945204
            // These are hardcoded lat, long, you can pass actual lat, long if your app uses gps
            UserExperior.setDeviceLocation(19.154023, 72.945204);
        } catch (Exception e) {
            e.printStackTrace();
        }

        final EditText editText = (EditText) findViewById(R.id.mPinET);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPin = editText.getText().toString();
                try {
                    UserExperior.setUserIdentifier(mPin);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        try {
            //UserExperior.startTimer("main activity timer");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printLog(Context context){
        String filename = context.getExternalFilesDir(null).getPath() + File.separator + SystemClock.uptimeMillis() + "_my_app.log";
        //String command = "logcat -f "+ filename + " -v time -d *:V";
        String command = "logcat -f "+ filename + " -v time -s userexperiorlogs";
        // logcat -f "+ filename + " -v time -d -s Tag1 Tag2
        Log.d("userexperiorlogs...", "command: " + command);

        try{
            Runtime.getRuntime().exec(command);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
