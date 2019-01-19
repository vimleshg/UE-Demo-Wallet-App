package com.userexperior.uewallet.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.userexperior.uewallet.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MobileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MobileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MobileFragment extends Fragment implements Mobile1.OnMob1Listener, Mobile2.OnMob2Listener
{
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MobileFragment()
    {
        // Required empty public constructor
    }


    public static MobileFragment newInstance()
    {
        MobileFragment fragment = new MobileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, "");
        args.putString(ARG_PARAM2, "");
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pay_to_merchant_mobile, container, false);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Fragment frag = new Mobile1();
        frag.setTargetFragment(this, 1);
        transaction.replace(R.id.frame_mobile, frag);
        transaction.commit();

        return v;

    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener)
        {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onMob1Interaction()
    {
        Fragment frag = new Mobile2();
        frag.setTargetFragment(this, 2);
        getChildFragmentManager().beginTransaction()
                .add(R.id.frame_mobile, frag)
                .commit();
    }

    @Override
    public void onMob2Interaction()
    {

    }

    public interface OnFragmentInteractionListener
    {

    }
}
