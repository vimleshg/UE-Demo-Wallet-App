package com.userexperior.uewallet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.userexperior.uewallet.R;

import java.util.List;

/**
 * Created by userexperior on 15-02-2017.
 */

public class MiniStatementListAdapter extends BaseAdapter {

    private Context context;
    private List<String> miniStatementList;

    public MiniStatementListAdapter(Context context, List<String> miniStatementList){
        this.context = context;
        this.miniStatementList = miniStatementList;
    }

    @Override
    public int getCount() {
        return miniStatementList.size();
    }

    @Override
    public Object getItem(int position) {
        return miniStatementList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.mini_statement_row, parent, false);
        return convertView;
    }
}
