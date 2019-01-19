package com.userexperior.uewallet.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.userexperior.uewallet.R;
import com.userexperior.UserExperior;
import com.userexperior.models.recording.enums.UeCustomType;

public class HomeAccountCardFragment extends Fragment
{
    public HomeAccountCardFragment()
    {
        // Required empty public constructor
    }

    public static HomeAccountCardFragment newInstance()
    {
        HomeAccountCardFragment fragment = new HomeAccountCardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_account_card, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        view.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try {
                    UserExperior.setCustomTag("My Card", UeCustomType.TAG);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
