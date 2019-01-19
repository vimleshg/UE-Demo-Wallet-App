package com.userexperior.uewallet.application;

import android.app.Application;
import com.userexperior.UserExperior;

/**
 * Created by userexperior on 18-02-2017.
 */

public class UeWalletApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UserExperior.init(getApplicationContext(), true);
    }
}
