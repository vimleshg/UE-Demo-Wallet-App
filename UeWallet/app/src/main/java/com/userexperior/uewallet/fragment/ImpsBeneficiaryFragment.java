package com.userexperior.uewallet.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.userexperior.uewallet.R;
import com.userexperior.uewallet.utils.Constants;
import com.userexperior.uewallet.utils.IntentUtils;


public class ImpsBeneficiaryFragment extends Fragment
{
    private static final String ARGS_BENEFICIARY = "beneficiary";
    public static final String TAG = ImpsBeneficiaryFragment.class.getSimpleName();

    private TextView account;
    private TextView name;
    private TextView nickName;
    private TextView ifsc;
    private TextView charges;
    private CheckBox saveBeneficiary;
    private Button submitButton;

    private boolean mNewBeneficiary;

    public ImpsBeneficiaryFragment()
    {
        // Required empty public constructor
    }

    public static ImpsBeneficiaryFragment newInstance(boolean newBeneficiary)
    {
        ImpsBeneficiaryFragment fragment = new ImpsBeneficiaryFragment();
        Bundle args = new Bundle();
        args.putBoolean(ARGS_BENEFICIARY, newBeneficiary);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            mNewBeneficiary = getArguments().getBoolean(ARGS_BENEFICIARY);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_imps_new_beneficiary, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        account = (TextView) view.findViewById(R.id.accNumber);
        name = (TextView) view.findViewById(R.id.name);
        nickName = (TextView) view.findViewById(R.id.nickName);
        ifsc = (TextView) view.findViewById(R.id.ifsc);
        charges = (TextView) view.findViewById(R.id.charges);
        saveBeneficiary = (CheckBox) view.findViewById(R.id.saveBeneficiary);

        if (!mNewBeneficiary)
        {
            saveBeneficiary.setVisibility(View.GONE);
        } else
        {
            account.setText("");
            name.setText("");
            nickName.setText("");
            ifsc.setText("");
        }

        submitButton = (Button) view.findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!submitButton.getText().toString().contains("Proceed"))
                {
                    charges.setText("+ \u20B9 50");
                    submitButton.setText("Proceed to Pay \u20B9 1250");
                } else
                {
                    String info = account.getText().toString() + "\n" + ifsc.getText().toString();
                    IntentUtils.startSendMoneyConfirm(getActivity(), name.getText().toString(), Constants.SendMoney.TYPE_IMPS, info, mNewBeneficiary);
                }
            }
        });
    }
}
