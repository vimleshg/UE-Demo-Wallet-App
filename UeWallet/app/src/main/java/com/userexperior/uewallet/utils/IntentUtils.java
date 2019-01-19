package com.userexperior.uewallet.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.userexperior.uewallet.BillPayElectricityActivity1;
import com.userexperior.uewallet.BillPayMobilePostPaidActivity1;
import com.userexperior.uewallet.Bus;
import com.userexperior.uewallet.Cab;
import com.userexperior.uewallet.DataCardPrePaid1;
import com.userexperior.uewallet.Events;
import com.userexperior.uewallet.Flight;
import com.userexperior.uewallet.HomeActivity;
import com.userexperior.uewallet.Hotls;
import com.userexperior.uewallet.LoadMoneyActivity;
import com.userexperior.uewallet.Main2Activity;
import com.userexperior.uewallet.PayToMerchantActivity;
import com.userexperior.uewallet.SendMoneyActivity;
import com.userexperior.uewallet.SendMoneyConfirmationActivity;
import com.userexperior.uewallet.Train;

public class IntentUtils
{
    public static void startSendMoney(Context context)
    {
        Intent intent = new Intent(context, SendMoneyActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public static void startSendMoneyConfirm(Context context, String name, String type, String info, boolean newBeneficiary)
    {
        Intent intent = new Intent(context, SendMoneyConfirmationActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("type", type);
        intent.putExtra("info", info);
        intent.putExtra("new_beneficiary", newBeneficiary);
        context.startActivity(intent);
    }

    public static void startLoadMoney(Context context)
    {
        Intent intent = new Intent(context, LoadMoneyActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public static void startHome(Context context)
    {
        Intent intent = new Intent(context, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }

    public static void startMerchant(Context context)
    {
        Intent intent = new Intent(context, PayToMerchantActivity.class);
        context.startActivity(intent);
    }

    public static void startPrepaid(Context context)
    {
        Intent intent = new Intent(context, DataCardPrePaid1.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public static void startPostpaid(Context context)
    {
        Intent intent = new Intent(context, BillPayMobilePostPaidActivity1.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public static void startElectricity(Context context)
    {
        Intent intent = new Intent(context, BillPayElectricityActivity1.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public static void startBookFlight(Context context)
    {
        Intent intent = new Intent(context, Flight.class);
        context.startActivity(intent);
    }

    public static void startBookTrain(Context context)
    {
        Intent intent = new Intent(context, Train.class);
        context.startActivity(intent);
    }

    public static void startBookBus(Context context)
    {
        Intent intent = new Intent(context, Bus.class);
        context.startActivity(intent);
    }

    public static void startBookHotel(Context context)
    {
        Intent intent = new Intent(context, Hotls.class);
        context.startActivity(intent);
    }

    public static void startBookCab(Context context)
    {
        Intent intent = new Intent(context, Cab.class);
        context.startActivity(intent);
    }

    public static void startBookEvents(Context context)
    {
        Intent intent = new Intent(context, Events.class);
        context.startActivity(intent);
    }

    public static void hideKeyboard(Context ctx) {
        InputMethodManager inputManager = (InputMethodManager) ctx
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        // check if no view has focus:
        View v = ((Activity) ctx).getCurrentFocus();
        if (v == null)
            return;

        inputManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    public static void startTabAct(Context context)
    {
        Intent intent = new Intent(context, Main2Activity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
}
