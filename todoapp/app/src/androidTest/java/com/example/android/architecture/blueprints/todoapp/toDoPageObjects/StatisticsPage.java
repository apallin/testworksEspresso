package com.example.android.architecture.blueprints.todoapp.toDoPageObjects;

import com.example.android.architecture.blueprints.todoapp.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Page Object for statistics page
 */

public class StatisticsPage {

    public static void checkStatisticsActivity() {
        onView(withId(R.id.statistics)).check(matches(isDisplayed()));
    }
}
