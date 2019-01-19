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
public class DetailedStatementListFragment extends Fragment {

    ListView detailedStatementLV;

    public DetailedStatementListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_detailed_statement_list, container, false);
        //detailedStatementLV = (ListView) rootView.findViewById(R.id.detailedStatementLV);
        //detailedStatementLV.setDivider(null);
        //detailedStatementLV.setDividerHeight(0);

        //List<String> detailedStatementList = new ArrayList<>();
        //detailedStatementList.add("one");
        //detailedStatementList.add("two");
        //DetailedStatementListAdapter detailedStatementListAdapter = new DetailedStatementListAdapter(getContext(), detailedStatementList);
        //detailedStatementLV.setAdapter(detailedStatementListAdapter);

        return rootView;
    }

}
