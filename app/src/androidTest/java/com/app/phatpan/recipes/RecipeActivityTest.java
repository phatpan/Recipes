package com.app.phatpan.recipes;

import android.content.Intent;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isSelected;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

/**
 * Created by phatpan on 5/7/2017 AD.
 */
public class RecipeActivityTest {
    private InMemoryFavortite favortite;

    @Rule
    public ActivityTestRule<RecipeActivity> activityActivityTestRule =
            new ActivityTestRule<RecipeActivity>(RecipeActivity.class,true,false);

    @Before
    private void cleanAllFavorite(){
        TestRecipeApplication application =(TestRecipeApplication)
                InstrumentationRegistry.getTargetContext().getApplicationContext();
        favortite = (InMemoryFavortite) application.getFavorite();
        favortite.clear();
    }

    @Test public void
    found_recipe(){
        Intent intent = new Intent();
        intent.putExtra("id", "1");
        activityActivityTestRule.launchActivity(intent);

        onView(withId(R.id.title))
                .check(matches(withText("Title1")));

        onView(withId(R.id.description))
                .check(matches(withText("Description")));
    }

    @Test
    public void click_to_favorite_recipe(){
        Intent intent = new Intent();
        intent.putExtra("id", 1);

        activityActivityTestRule.launchActivity(intent);

        onView(withId(R.id.title))
                .check(matches(withText("Title1")))
                .check(matches(not(isSelected())));

        onView(withId(R.id.title))
                .perform(click());

        onView(withId(R.id.title))
                .check(matches(isSelected()));


    }




}