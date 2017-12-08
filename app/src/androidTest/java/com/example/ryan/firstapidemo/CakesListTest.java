package com.example.ryan.firstapidemo;

import android.content.Intent;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ScrollToAction;
import android.support.test.rule.ActivityTestRule;
import android.widget.ScrollView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Ryan on 07/12/2017.
 */

@RunWith(JUnit4.class)
public class CakesListTest {

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        activityActivityTestRule.getActivity();
    }

    @Test
    public void testRecyclerView(){

        onView(withId(R.id.rvCakes))
                .check(matches(isDisplayed()));

        ViewInteraction perform = onView(withId(R.id.rvCakes)).perform(scrollToPosition(1));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withText("victoria sponge")).check(matches(isDisplayed()));

    }

}
