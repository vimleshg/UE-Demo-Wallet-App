package com.userexperior.uewallet.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.userexperior.uewallet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MiniStatementFragment extends Fragment {


    ListView miniStatementLV;

    public MiniStatementFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_mini_statement, container, false);
        //miniStatementLV = (ListView) rootView.findViewById(R.id.miniStatementLV);
        //miniStatementLV.setDivider(null);
        //miniStatementLV.setDividerHeight(0);

        //List<String> miniStatementList = new ArrayList<>();
        //miniStatementList.add("one");
        //miniStatementList.add("two");
        //MiniStatementListAdapter miniStatementListAdapter = new MiniStatementListAdapter(getContext(), miniStatementList);
        //miniStatementLV.setAdapter(miniStatementListAdapter);

        return rootView;
    }

}
