package com.userexperior.uewallet.fragment;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.userexperior.uewallet.R;
import com.userexperior.uewallet.utils.IntentUtils;
import com.userexperior.UserExperior;
import com.userexperior.models.recording.enums.UeCustomType;

public class HomeWalletCardFragment extends Fragment
{
    View mLoadMoneyButton;
    ProgressBar progressBar;

    int i = 0;

    CountDownTimer countDownTimer;

    public HomeWalletCardFragment()
    {
        // Required empty public constructor
    }

    public static HomeWalletCardFragment newInstance()
    {
        HomeWalletCardFragment fragment = new HomeWalletCardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home_wallet_card, container, false);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
        progressBar.setProgress(i);
        return rootView;
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
                //IntentUtils.startWalletSummary(getActivity());
            }
        });

        mLoadMoneyButton = view.findViewById(R.id.load_money);
        mLoadMoneyButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try {
                    UserExperior.startTimer("Time taken to Load Money");
                } catch (Exception e) {
                    e.printStackTrace();
                }



                try {
                    UserExperior.setCustomTag("Add To Cart", UeCustomType.EVENT);
                    //UserExperior.setCustomTag("Add To Cart");
                } catch (Exception e) {
                    e.printStackTrace();
                }




                progressBar.setVisibility(View.VISIBLE);
                mLoadMoneyButton.setEnabled(false);
                countDownTimer=new CountDownTimer(5000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        Log.v("Log_tag", "Tick of Progress"+ i+ millisUntilFinished);
                        i++;
                        progressBar.setProgress(i);
                    }

                    @Override
                    public void onFinish() {
                        //Do what you want
                        i++;
                        progressBar.setProgress(i);
                        progressBar.setVisibility(View.INVISIBLE);
                        mLoadMoneyButton.setEnabled(true);
                        IntentUtils.startLoadMoney(getActivity());
                        countDownTimer.cancel();
                    }
                };
                countDownTimer.start();

                //IntentUtils.startLoadMoney(getActivity());
            }
        });
    }
}
