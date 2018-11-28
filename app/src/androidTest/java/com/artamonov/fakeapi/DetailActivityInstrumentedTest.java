package com.artamonov.fakeapi;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.artamonov.fakeapi.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNot.not;

/**
 * Instrumented test, which will execute on an Android device.
 * <p>
 * The test checks whether the user email field contains '@' and user name is not null.
 * Besides, the test checks whether the toolbar is displayed.
 */
@RunWith(AndroidJUnit4.class)
public class DetailActivityInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {

        onView(withId(R.id.rv_posts)).perform(click());
        onView(withId(R.id.user_name)).check(matches(not(withText(""))));
        onView(withId(R.id.user_email)).check(matches(withText(containsString("@"))));
        onView(withId(R.id.toolbar)).check(matches(isDisplayed()));

    }
}
