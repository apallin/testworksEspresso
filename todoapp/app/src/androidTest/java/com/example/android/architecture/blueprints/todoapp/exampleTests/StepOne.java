package com.example.android.architecture.blueprints.todoapp.exampleTests;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.tasks.TasksActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Test Example One
 * Basic test for opening the add task page by clicking on the add task button
 */

@RunWith(AndroidJUnit4.class)
public class StepOne {

    @Rule
    public ActivityTestRule<TasksActivity> mActivityTestRule =
            new ActivityTestRule<>(TasksActivity.class);

    @Test
    public void openAddTaskPage() {
        // Click on the add task button
        onView(withId(R.id.fab_add_task)).perform(click());

        // Check if the add task page opened
        onView(withId(R.id.add_task_title)).check(matches(isDisplayed()));
    }
}

