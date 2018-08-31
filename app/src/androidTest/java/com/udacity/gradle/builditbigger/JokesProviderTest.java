package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class JokesProviderTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testJokeIsNonEmptyString() {
        String joke = null;
        JokeProviderEndpointsAsyncTask asyncTask = new JokeProviderEndpointsAsyncTask();
        asyncTask.execute(activityTestRule.getActivity().getApplicationContext());

        try {
            joke = asyncTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        assertNotNull("joke must not be null", joke);
        assertFalse("joke must not be empty string", joke.isEmpty());
    }
}
