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

public class MobileBeneficiaryFragment extends Fragment
{
    private static final String ARGS_BENEFICIARY = "beneficiary";
    public static final String TAG = MobileBeneficiaryFragment.class.getSimpleName();

    private boolean mNewBeneficiary;

    private TextView mobile;
    private TextView name;
    private TextView amount;
    private CheckBox saveBeneficiary;
    private Button submitButton;

    public static MobileBeneficiaryFragment newInstance(boolean newBeneficiary)
    {
        MobileBeneficiaryFragment fragment = new MobileBeneficiaryFragment();
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
        return inflater.inflate(R.layout.fragment_mobile_beneficiary, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        mobile = (TextView) view.findViewById(R.id.mobile);
        name = (TextView) view.findViewById(R.id.name);
        amount = (TextView) view.findViewById(R.id.amount);
        saveBeneficiary = (CheckBox) view.findViewById(R.id.saveBeneficiary);

        if (!mNewBeneficiary)
        {
            saveBeneficiary.setVisibility(View.GONE);
        } else
        {
            mobile.setText("");
            name.setText("");
            amount.setText("");
        }

        submitButton = (Button) view.findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                IntentUtils.startSendMoneyConfirm(getActivity(), name.getText().toString(), Constants.SendMoney.TYPE_MOBILE, mobile.getText().toString(), mNewBeneficiary);
            }
        });
    }
}
