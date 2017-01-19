package cice.testdemo;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.action.ViewActions.click;


/**
 * Created by Antonio on 18/11/2016.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTests {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testButtonAntonio() {
        onView(withId(R.id.editText))
                .perform(typeText("Antonio"), closeSoftKeyboard());
        onView(withText("Button")).perform(click());

        onView(withId(R.id.textView))
                .check(matches(withText("Hola Antonio")));
    }

    @Test
    public void testButtonInvisible() {
        onView(withId(R.id.editText))
                .perform(typeText("ocultar"), closeSoftKeyboard());
        onView(withText("Button")).perform(click());

        onView(withId(R.id.textView))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
    }
}
