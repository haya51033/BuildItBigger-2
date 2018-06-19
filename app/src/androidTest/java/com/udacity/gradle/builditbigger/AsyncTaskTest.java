package com.udacity.gradle.builditbigger;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.yousef.jokeprovider.JokeGenerator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.regex.Matcher;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {
    IdlingRegistry idlingRegistry;
    IdlingResource idlingResource;
    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void getIdlingResource(){
        idlingResource = activityActivityTestRule.getActivity().getIdlingResource();
        idlingRegistry = IdlingRegistry.getInstance();
        idlingRegistry.register(idlingResource);
    }

    @Test
    public void checkAsyncResult(){
        Espresso.onView(ViewMatchers.withId(R.id.btn_tell_joke)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.tv_joke_holder)).
                check(ViewAssertions.
                        matches(ViewMatchers.withText(new  JokeGenerator().getJoke())));

        boolean bool = (activityActivityTestRule.getActivity().asyncTaskString).equals(new  JokeGenerator().getJoke());
        Log.e("Test", "boolean = " + bool);
    }
}
