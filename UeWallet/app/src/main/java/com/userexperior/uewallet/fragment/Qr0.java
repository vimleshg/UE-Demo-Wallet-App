package com.userexperior.uewallet.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.userexperior.uewallet.R;

/**
 * Created by vivek-pc on 2/16/2017.
 */

public class Qr0 extends Fragment {

    OnQr0Listener listener;

    public interface OnQr0Listener {
        void onQr0Interaction();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.qr0, container, false);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener = (OnQr0Listener) getTargetFragment();
                listener.onQr0Interaction();
            }
        });

        return v;
    }
}


