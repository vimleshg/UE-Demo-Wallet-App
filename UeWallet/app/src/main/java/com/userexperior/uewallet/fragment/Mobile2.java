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

public  class Mobile2 extends Fragment {

    OnMob2Listener listener;

    public interface OnMob2Listener {
        void onMob2Interaction();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.mobile2, container, false);
        v.findViewById(R.id.mob2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener = (OnMob2Listener) getTargetFragment();
                listener.onMob2Interaction();

            }
        });

        return v;
    }
}
