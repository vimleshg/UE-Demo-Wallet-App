package com.userexperior.uewallet.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.userexperior.uewallet.R;
import com.userexperior.uewallet.utils.HomeConstants;

public class HomeAdapter extends RecyclerView.Adapter
{
    private final Context mContext;

    String titles[] = {
            "Transfers", //Pay
            "Bill Payments", //Recharge & BillPay
            "Tickets", //Book
            "Settings", //Manage
    };
    private HorizontalHomeAdapter mPayAdapter;
    private HorizontalHomeAdapter mRechargeAdapter;
    private HorizontalHomeAdapter mBookAdapter;
    private HorizontalHomeAdapter mProductAdapter;
    private HorizontalHomeAdapter mManageAdapter;
    private HorizontalHomeAdapter mApplyForAdapter;

    public HomeAdapter(Context context)
    {
        mContext = context;
        mPayAdapter = new HorizontalHomeAdapter(mContext, HomeConstants.Pay.icons, HomeConstants.Pay.texts);
        mRechargeAdapter = new HorizontalHomeAdapter(mContext, HomeConstants.Recharge.icons, HomeConstants.Recharge.texts);
        mBookAdapter = new HorizontalHomeAdapter(mContext, HomeConstants.Book.icons, HomeConstants.Book.texts);
        mManageAdapter = new HorizontalHomeAdapter(mContext, HomeConstants.Manage.icons, HomeConstants.Manage.texts);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_home, parent, false);
        RecyclerView.ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        switch (position)
        {
            case 0:
                if (viewHolder.recyclerView.getAdapter() != mPayAdapter)
                {
                    viewHolder.recyclerView.setAdapter(mPayAdapter);
                }
                break;
            case 1:
                if (viewHolder.recyclerView.getAdapter() != mRechargeAdapter)
                {
                    viewHolder.recyclerView.setAdapter(mRechargeAdapter);
                }
                break;
            case 2:
                if (viewHolder.recyclerView.getAdapter() != mBookAdapter)
                {
                    viewHolder.recyclerView.setAdapter(mBookAdapter);
                }
                break;
            case 3:
                if (viewHolder.recyclerView.getAdapter() != mManageAdapter)
                {
                    viewHolder.recyclerView.setAdapter(mManageAdapter);
                }
                break;
        }
        //viewHolder.title.setText(titles[position]);
    }

    @Override
    public int getItemCount()
    {
        return titles.length;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        RecyclerView recyclerView;

        public ViewHolder(View itemView)
        {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
        }
    }

}
