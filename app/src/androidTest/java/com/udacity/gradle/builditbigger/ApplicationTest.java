package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Tests the app to make sure we can retrieve a joke from the server.
 * NOTE: Make sure the server is running before running the test.
 */
public class ApplicationTest extends AndroidTestCase {

    private final CountDownLatch mSignal = new CountDownLatch(1);

    public void testJokeRetriever() {
        new RetrieveJoke(new TestJokeListener()).execute();
        try {
            boolean success = mSignal.await(5, TimeUnit.SECONDS);
            if (!success) {
                fail("Server not running.");
            }
        } catch (InterruptedException e) {
            fail();
        }
    }

    private class TestJokeListener implements RetrieveJoke.OnJokeRetrievedListener {

        @Override
        public void onJokeRetrieved(String joke) {
            assertTrue(joke != null && joke.length() > 0);
            mSignal.countDown();
        }
    }
}