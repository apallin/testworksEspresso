package com.example.android.architecture.blueprints.todoapp.testworksTests;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.tasks.TasksActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Test Example Two
 * Basic test for creating a test with a defined title/description
 */

@RunWith(AndroidJUnit4.class)
public class TestTwo {

    private final static String TESTTITLE = "TEST TITLE";

    private final static String TESTDESCR = "TEST DESCRIPTION";

    @Rule
    public ActivityTestRule<TasksActivity> mActivityTestRule =
            new ActivityTestRule<>(TasksActivity.class);

    @Test
    public void createOneTask() {
        // Click on the add task button
        onView(withId(R.id.fab_add_task)).perform(click());

        // Add task title and description
        onView(withId(R.id.add_task_title)).perform(typeText(TESTTITLE),
                closeSoftKeyboard()); // Type new task title
        onView(withId(R.id.add_task_description)).perform(typeText(TESTDESCR),
                closeSoftKeyboard()); // Type new task description and close the keyboard

        // Save the task
        onView(withId(R.id.fab_edit_task_done)).perform(click());
    }
}
