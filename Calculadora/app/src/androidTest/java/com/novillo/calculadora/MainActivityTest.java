package com.novillo.calculadora;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by cice on 12/1/17.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void TestBotonesNumeros() {

        onView(withId(R.id.boton1)).perform(click());

        onView(withId(R.id.pantalla))
                .check(matches(withText("1")));

        onView(withId(R.id.boton2)).perform(click());

        onView(withId(R.id.pantalla))
                .check(matches(withText("12")));

        onView(withId(R.id.boton3)).perform(click());

        onView(withId(R.id.pantalla))
                .check(matches(withText("123")));

        onView(withId(R.id.botonPunto)).perform(click());

        onView(withId(R.id.pantalla))
                .check(matches(withText("123.")));

        onView(withId(R.id.boton8)).perform(click());

        onView(withId(R.id.pantalla))
                .check(matches(withText("123.8")));

        onView(withId(R.id.boton9)).perform(click());

        onView(withId(R.id.pantalla))
                .check(matches(withText("123.89")));
    }

    @Test
    public void TestBotonSumar() {

        onView(withId(R.id.boton2)).perform(click());
        onView(withId(R.id.botonSumar)).perform(click());
        onView(withId(R.id.boton2)).perform(click());
        onView(withId(R.id.botonIgual)).perform(click());


        onView(withId(R.id.pantalla))
                .check(matches(withText("4.0")));
    }

    @Test
    public void TestBotonMultiplicar() {

        onView(withId(R.id.boton2)).perform(click());
        onView(withId(R.id.botonMultiplicar)).perform(click());
        onView(withId(R.id.boton5)).perform(click());
        onView(withId(R.id.botonIgual)).perform(click());


        onView(withId(R.id.pantalla))
                .check(matches(withText("10.0")));
    }

    @Test
    public void TestBotonRestar() {

        onView(withId(R.id.boton9)).perform(click());
        onView(withId(R.id.botonRestar)).perform(click());
        onView(withId(R.id.boton7)).perform(click());
        onView(withId(R.id.botonIgual)).perform(click());


        onView(withId(R.id.pantalla))
                .check(matches(withText("2.0")));
    }

    @Test
    public void TestBotonDividir() {

        onView(withId(R.id.boton1)).perform(click());
        onView(withId(R.id.boton0)).perform(click());
        onView(withId(R.id.botonDividir)).perform(click());
        onView(withId(R.id.boton5)).perform(click());
        onView(withId(R.id.botonIgual)).perform(click());


        onView(withId(R.id.pantalla))
                .check(matches(withText("2.0")));
    }
}
