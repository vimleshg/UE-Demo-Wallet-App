package com.userexperior.uewallet.utils;

import com.userexperior.uewallet.R;

public class HomeConstants
{
    public static class Pay
    {
        public static final String MERCHANT = "Pay to Merchant";
        public static final String SEND = "Send Money";

        public static final int[] icons = {
                R.drawable.pay_to_merchant,
                R.drawable.send,
        };
        public static final String[] texts = {
                MERCHANT,
                SEND,
        };
    }

    public static class Recharge
    {
        public static final String PREPAID = "Mobile Top-up";
        public static final String POSTPAID = "Mobile Bill Pay";
        public static final String ELECTRICITY = "Electricity Bill";

        public static final int[] icons = {
                R.drawable.prepaid,
                R.drawable.post_paid,
                R.drawable.electricity,
        };
        public static final String[] texts = {
                PREPAID,
                POSTPAID,
                ELECTRICITY,
        };
    }

    public static class Book
    {
        public static final String FLIGHT = "Flight";
        public static final String TRAIN = "Train";
        public static final String BUS = "Bus";
        public static final String HOTELS = "Hotels";
        public static final String CAB = "Cab";
        public static final String MOVIE = "Movie";
        public static final String EVENTS = "Events";
        public static final String SPORTS = "Sports";

        public static final int[] icons = {
                R.drawable.hotel,
                R.drawable.cab,
                R.drawable.flight,
                R.drawable.train,
                R.drawable.bus,
                R.drawable.movie,
                R.drawable.sports,
        };
        public static final String[] texts = {
                HOTELS,
                CAB,
                FLIGHT,
                TRAIN,
                BUS,
                MOVIE,
                SPORTS,
        };
    }

    public static class Manage
    {

        public static final String BENEFICIARY = "Profile Setting";
        public static final String TAB_ACT = "Tabs Activity";

        public static final int[] icons = {
                R.drawable.beneficiary, R.drawable.beneficiary
        };
        public static final String[] texts = {
                BENEFICIARY, TAB_ACT
        };
    }
}
