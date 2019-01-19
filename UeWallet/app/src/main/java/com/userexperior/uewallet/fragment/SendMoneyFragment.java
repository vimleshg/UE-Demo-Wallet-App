package com.userexperior.uewallet.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.userexperior.uewallet.R;

public class SendMoneyFragment extends Fragment
{
    public static final String TAG = SendMoneyFragment.class.getSimpleName();

    public static final String TYPE_ACCOUNT = "account";
    public static final String TYPE_METHOD = "method";
    public static final String TYPE_BENEFICIARY = "beneficiary";

    private TextView mSelectAccount;
    private TextView mSelectMethod;
    private TextView mSelectBeneficiary;
    private OnFragmentInteractionListener mListener;


    public SendMoneyFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_send_money, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        mSelectAccount = (TextView) view.findViewById(R.id.selectAccount);
        mSelectAccount.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mListener.populateItems(TYPE_ACCOUNT);
            }
        });

        mSelectMethod = (TextView) view.findViewById(R.id.selectMethod);
        mSelectMethod.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mListener.populateItems(TYPE_METHOD);
            }
        });

        mSelectBeneficiary = (TextView) view.findViewById(R.id.selectBeneficiary);
        mSelectBeneficiary.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mListener.populateItems(TYPE_BENEFICIARY);
            }
        });
    }

    public void onAccountSelected(String text)
    {
        mSelectAccount.setText(text);
    }

    public void onMethodSelected(String text)
    {
        mSelectMethod.setText(text);
    }

    public void onBeneficiarySelected(String text)
    {
        mSelectBeneficiary.setText(text);
        if (mSelectMethod.getText().toString().equals("Mobile"))
        {
            if (text.equals("New Beneficiary"))
            {
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.childContainer, MobileBeneficiaryFragment.newInstance(true), MobileBeneficiaryFragment.TAG)
                        .commit();
            } else
            {
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.childContainer, MobileBeneficiaryFragment.newInstance(false), MobileBeneficiaryFragment.TAG)
                        .commit();
            }
        }
        if (mSelectMethod.getText().toString().equals("Instant IMPS"))
        {
            if (text.equals("New Beneficiary"))
            {
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.childContainer, ImpsBeneficiaryFragment.newInstance(true), ImpsBeneficiaryFragment.TAG)
                        .commit();
            } else
            {
                getChildFragmentManager().beginTransaction()
                        .replace(R.id.childContainer, ImpsBeneficiaryFragment.newInstance(false), ImpsBeneficiaryFragment.TAG)
                        .commit();
            }
        }
    }

    @Override
    public void onAttach(Context activity)
    {
        super.onAttach(activity);
        try
        {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener
    {
        void populateItems(String type);
    }


}
