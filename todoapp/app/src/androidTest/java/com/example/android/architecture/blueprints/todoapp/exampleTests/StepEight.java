package com.example.android.architecture.blueprints.todoapp.exampleTests;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.android.architecture.blueprints.todoapp.Injection;
import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.data.source.TasksDataSource;
import com.example.android.architecture.blueprints.todoapp.statistics.StatisticsActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Test Example Seven
 * Add complete test for opening statistics screen and navigating back to To-Do list
 * Now openStatisticsNavView should pass
 */

@RunWith(AndroidJUnit4.class)
public class StepEight {

    @Rule
    public ActivityTestRule<StatisticsActivity> mStatisticsActivityTestRule =
            new ActivityTestRule<StatisticsActivity>(StatisticsActivity.class) {

                /**
                 * To avoid a long list of tasks and the need to scroll through the list to find a
                 * task, we call {@link TasksDataSource#deleteAllTasks()} before each test.
                 */
                @Override
                protected void beforeActivityLaunched() {
                    super.beforeActivityLaunched();
                    Injection.provideTasksRepository(InstrumentationRegistry.getTargetContext())
                            .deleteAllTasks();
                }
            };

    @Test
    public void validateLaunchedStatistics() {
        // Check that Statistics Activity was opened.
        onView(withId(R.id.statistics)).check(matches(isDisplayed()));
    }
}
