package com.userexperior.uewallet;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.model.Statement;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest{
    private UiDevice mDevice;
    private static final String BASIC_SAMPLE_PACKAGE = "com.userexperior.uewallet";
    private static final int LAUNCH_TIMEOUT = 5000;

    @Rule
    public RepeatRule repeatRule = new RepeatRule();

    public static int i = 0;

    @Before
    public void startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        mDevice.pressHome();

        // Wait for launcher
        final String launcherPackage = getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);

        // Launch the blueprint app
        Context context = InstrumentationRegistry.getContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(BASIC_SAMPLE_PACKAGE);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);    // Clear out any previous instances
        context.startActivity(intent);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(BASIC_SAMPLE_PACKAGE).depth(0)), LAUNCH_TIMEOUT);
    }


    private String getLauncherPackageName() {
        // Create launcher Intent
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        // Use PackageManager to get the launcher package name
        PackageManager pm = InstrumentationRegistry.getContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }

    @Test
    @RepeatRule.Repeat(times = 20)
    public void regularFlowTest(){
        // regular flow test
        onView(withId(R.id.mPinET)).perform(typeText("12345786"),
                closeSoftKeyboard());
        onView(withId(R.id.loginBtn)).perform(click());
        mDevice = UiDevice.getInstance(getInstrumentation());
        mDevice.pressHome();
    }

    public static class RepeatRule implements TestRule {
        @Retention(RetentionPolicy.RUNTIME)
        @Target({
                java.lang.annotation.ElementType.METHOD
        })
        public @interface Repeat {
            public abstract int times();
        }

        private static class RepeatStatement extends Statement {

            private final int times;
            private final Statement statement;

            private RepeatStatement(int times, Statement statement) {
                this.times = times;
                this.statement = statement;
            }

            @Override
            public void evaluate() throws Throwable {
                for (int i = 0; i < times; i++) {
                    statement.evaluate();
                }
            }
        }

        @Override
        public Statement apply(Statement statement, Description description) {
            Statement result = statement;
            Repeat repeat = description.getAnnotation(Repeat.class);
            if (repeat != null) {
                int times = repeat.times();
                result = new RepeatStatement(times, statement);
            }
            return result;
        }
    }
}