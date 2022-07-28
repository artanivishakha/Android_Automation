package com.abnamro.apps.referenceandroid;

import static android.app.PendingIntent.getActivity;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.accessibility.AccessibilityChecks;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
//execute as JUNIT4 test
@LargeTest
//signifies test itself takes more than
public class FirstTest {

        @Rule
        public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
                MainActivity.class);
        //Junit rule

        @Before
        //Accessibility testing checks
        public  void enableAccessibilityChecks() {
            AccessibilityChecks.enable();

        }

        @Test
        public void testRefAndroid() {
            //Validate Reference Android
            onView(withText("Reference Android").check(matches(isDisplayed())));
            //Click on Settings button
            onView(withText("More options").perform(click()));
            //Click on back button
            pressBack();

        }
        @Test
        public void message() {
            onView(allOF(withId(R.id.fab)).isClickable());
            //Check if message box is clickable
            onView(withId(R.id.fragment).isDisplayed());
            //Check if message is displayed
        }

        @Test//Scenario if on pressing message box email screen is opened
        public void email() {
            onView(allOf(withId(R.id.fab)).isClickable());
            onView(withText("email").isDisplayed());
            onView((withText("Send").perform(click())));
        }
        @After
        public void tearDown() throws Exception {
        //Clearning up the resources after test
        }

}
    }
