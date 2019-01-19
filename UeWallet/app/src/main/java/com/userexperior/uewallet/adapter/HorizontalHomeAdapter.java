package com.userexperior.uewallet.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.userexperior.uewallet.R;
import com.userexperior.uewallet.utils.HomeConstants;
import com.userexperior.uewallet.utils.IntentUtils;
import com.squareup.picasso.Picasso;
import com.userexperior.UserExperior;

public class HorizontalHomeAdapter extends RecyclerView.Adapter
{
    private int[] icons;
    private String[] text;
    private Context mContext;

    public HorizontalHomeAdapter(Context context, int[] icons, String[] text)
    {
        mContext = context;
        this.icons = icons;
        this.text = text;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_icon_text, parent, false);
        RecyclerView.ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position)
    {
        ViewHolder viewHolder = (ViewHolder) holder;
        Picasso.with(mContext).load(icons[position]).into(viewHolder.image);

        final String textString = text[position];
        viewHolder.text.setText(text[position]);

        viewHolder.parent.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch (textString)
                {
                    case HomeConstants.Pay.MERCHANT:
                        IntentUtils.startMerchant(mContext);
                        break;
                    case HomeConstants.Pay.SEND:
                        // to produce anr
                        int i = 0;
                        while(true){
                            i++;
                        }

                        //IntentUtils.startSendMoney(mContext);
                        //break;
                    case HomeConstants.Recharge.PREPAID:
                        IntentUtils.startPrepaid(mContext);
                        break;
                    case HomeConstants.Recharge.POSTPAID:
                        IntentUtils.startPostpaid(mContext);
                        break;
                    case HomeConstants.Recharge.ELECTRICITY:
                        IntentUtils.startElectricity(mContext);
                        break;
                    case HomeConstants.Book.FLIGHT:
                        UserExperior.pauseRecording();
                        IntentUtils.startBookFlight(mContext);
                        break;
                    case HomeConstants.Book.TRAIN:
                        UserExperior.resumeRecording();
                        IntentUtils.startBookTrain(mContext);
                        break;
                    case HomeConstants.Book.BUS:
                        IntentUtils.startBookBus(mContext);
                        break;
                    case HomeConstants.Book.HOTELS:
                        IntentUtils.startBookHotel(mContext);
                        break;
                    case HomeConstants.Book.CAB:
                        IntentUtils.startBookCab(mContext);
                        break;
                    case HomeConstants.Book.EVENTS:
                        IntentUtils.startBookEvents(mContext);
                        break;
                    case HomeConstants.Manage.BENEFICIARY:
                        UserExperior.resumeRecording();
                        break;
                    case HomeConstants.Manage.TAB_ACT:
                        IntentUtils.startTabAct(mContext);

                }
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return icons.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        static View parent;
        ImageView image;
        static TextView text;

        public ViewHolder(View itemView)
        {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            text = (TextView) itemView.findViewById(R.id.text);

            parent = itemView;
        }

        public static View getParentView(){
            return parent;
        }

        public static String getItemText(){
            return text.getText().toString();
        }
    }
}
