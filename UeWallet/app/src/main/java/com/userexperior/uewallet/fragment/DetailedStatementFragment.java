package com.userexperior.uewallet.fragment;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.userexperior.uewallet.MyStatementDownloadConfirmActivity;
import com.userexperior.uewallet.MyStatementEmailConfirmActivity;
import com.userexperior.uewallet.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailedStatementFragment extends Fragment
{


    ImageView fromDateIV, toDateIV, downloadStatementIV, emailStatementIV, submitStatementIV;
    Calendar myCalendar;
    EditText fromDateET, toDateET;
    Spinner benificiarySpinner, allTransactionSpinner, rowCountSpinner;
    View parent;
    private View rootView;
    private boolean mToDetails;

    public DetailedStatementFragment()
    {
        // Required empty public constructor
    }

    public static DetailedStatementFragment newInstance(boolean toDetails)
    {
        DetailedStatementFragment fragment = new DetailedStatementFragment();
        Bundle args = new Bundle();
        args.putBoolean("to_details", toDetails);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            mToDetails = getArguments().getBoolean("to_details");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_detailed_statement, container, false);

        fromDateIV = (ImageView) rootView.findViewById(R.id.fromDateIV);
        toDateIV = (ImageView) rootView.findViewById(R.id.toDateIV);

        downloadStatementIV = (ImageView) rootView.findViewById(R.id.downloadStatementIV);
        downloadStatementIV.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getContext(), MyStatementDownloadConfirmActivity.class);
                startActivity(intent);
            }
        });

        emailStatementIV = (ImageView) rootView.findViewById(R.id.emailStatementIV);
        emailStatementIV.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getContext(), MyStatementEmailConfirmActivity.class);
                startActivity(intent);
            }
        });

        submitStatementIV = (ImageView) rootView.findViewById(R.id.submitStatementIV);
        parent = (View) rootView.findViewById(R.id.parentRL);
        submitStatementIV.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                openList();
                //getView().setVisibility(View.GONE);
            }
        });

        fromDateET = (EditText) rootView.findViewById(R.id.fromDateET);
        toDateET = (EditText) rootView.findViewById(R.id.toDateET);
        benificiarySpinner = (Spinner) rootView.findViewById(R.id.benificiarySpinner);
        allTransactionSpinner = (Spinner) rootView.findViewById(R.id.allTransactionSpinner);
        rowCountSpinner = (Spinner) rootView.findViewById(R.id.rowCountSpinner);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, new String[]{"Select Benificiary", "Mukesh Gupta", "Anil Shinde", "Robin Singh"}); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        benificiarySpinner.setAdapter(spinnerArrayAdapter);

        spinnerArrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, new String[]{"All Transactions", "Credit", "Debit"}); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        allTransactionSpinner.setAdapter(spinnerArrayAdapter);

        spinnerArrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, new String[]{"Per page", "10", "20", "30", "40"}); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rowCountSpinner.setAdapter(spinnerArrayAdapter);

        myCalendar = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener date1 = new DatePickerDialog.OnDateSetListener()
        {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth)
            {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateFromDateLabel();
            }

        };

        final DatePickerDialog.OnDateSetListener date2 = new DatePickerDialog.OnDateSetListener()
        {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth)
            {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateToDateLabel();
            }

        };

        fromDateIV.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new DatePickerDialog(getContext(), date1, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        toDateIV.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                new DatePickerDialog(getContext(), date2, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
//        if (mToDetails){
//            openList();
//        }
    }

    public void openList()
    {

        rootView.findViewById(R.id.parentFL).setPadding(0, 0, 0, 0);
        parent.setVisibility(View.GONE);
        getChildFragmentManager().beginTransaction().replace(R.id.listContainer, new DetailedStatementListFragment(), "Detailed Statement Fragment").commit();
        getChildFragmentManager().executePendingTransactions();
    }


    private void updateFromDateLabel()
    {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        fromDateET.setText(sdf.format(myCalendar.getTime()));
    }

    private void updateToDateLabel()
    {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        toDateET.setText(sdf.format(myCalendar.getTime()));
    }

}
