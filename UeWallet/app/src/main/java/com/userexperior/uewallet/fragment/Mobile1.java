package com.userexperior.uewallet.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.userexperior.uewallet.R;
import com.userexperior.uewallet.utils.IntentUtils;

/**
 * Created by vivek-pc on 2/16/2017.
 */

public class Mobile1 extends Fragment {

    OnMob1Listener listener;

    public interface OnMob1Listener {
        void onMob1Interaction();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.mobile1, container, false);
        v.findViewById(R.id.mob1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener = (OnMob1Listener) getTargetFragment();
                listener.onMob1Interaction();
                IntentUtils.hideKeyboard(getActivity()); // hide soft keyboard
            }
        });

        return v;
    }


}
