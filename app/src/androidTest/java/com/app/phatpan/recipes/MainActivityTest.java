package com.app.phatpan.recipes;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by phatpan on 5/7/2017 AD.
 */
public class MainActivityTest {

    @Rule
    public  ActivityTestRule<MainActivity> activityActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test public void
    clickSelectedItem(){
        onView(withId(R.id.recipes))
                .perform(RecyclerViewActions.actionOnItemAtPosition(19,click()));

        onView(withId(R.id.title))
                .check(matches(withText("Title19")))
                .check(matches(isDisplayed()));
    }

}