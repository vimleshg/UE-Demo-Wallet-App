package com.userexperior.uewallet;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.view.View;

import org.hamcrest.Matcher;

import java.util.ArrayList;

/**
 * Created by userexperior on 03-08-2017.
 */

public class MyViewAction {

    public static ViewAction clickChildViewWithId(final int id) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return null;
            }

            @Override
            public String getDescription() {
                return "Click on a child view with specified id.";
            }

            @Override
            public void perform(UiController uiController, View view) {
                View v = view.findViewById(id);
                //v.performClick();

                ArrayList<View> views = new ArrayList<>();

                view.findViewsWithText(views, "Electricity Bill", 0);

                views.get(0).performClick();

            }
        };
    }

}
