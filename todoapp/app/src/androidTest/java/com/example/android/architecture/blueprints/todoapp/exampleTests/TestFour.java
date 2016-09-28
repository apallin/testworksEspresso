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
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Test Example Four
 * Add test for editing a task.
 * The edit test task should fail for this until we implement a way to clear data.
 */

@RunWith(AndroidJUnit4.class)
public class TestFour {

    private final static String TESTTITLE = "TEST TITLE";

    private final static String TESTDESCR = "TEST DESCRIPTION";

    private final static String TESTTITLE2 = "SECOND TEST TITLE";

    private final static String TESTDESC2 = "SECOND TEST DESCRIPTION";

    @Rule
    public ActivityTestRule<TasksActivity> mActivityTestRule =
            new ActivityTestRule<>(TasksActivity.class);

    @Test
    public void createOneTask() {
        createTask(TESTTITLE, TESTDESCR);
    }

    @Test
    public void createSecondTask() {
        createTask(TESTTITLE2, TESTDESC2);
    }

    @Test
    public void editTask() {
        // First add a task
        createTask(TESTTITLE, TESTDESCR);

        // Click on the task on the list
        onView(withText(TESTTITLE)).perform(click());

        // Click on the edit task button
        onView(withId(R.id.fab_edit_task)).perform(click());

        String editTaskTitle = "Edited Title";
        String editTaskDescription = "Edited Description";

        // Edit task title and description
        onView(withId(R.id.add_task_title))
                .perform(replaceText(editTaskTitle), closeSoftKeyboard()); // Type new task title
        onView(withId(R.id.add_task_description)).perform(replaceText(editTaskDescription),
                closeSoftKeyboard()); // Type new task description and close the keyboard

        // Save the task
        onView(withId(R.id.fab_edit_task_done)).perform(click());
    }

    private void createTask(String title, String description) {
        // Click on the add task button
        onView(withId(R.id.fab_add_task)).perform(click());

        // Add task title and description
        onView(withId(R.id.add_task_title)).perform(typeText(title),
                closeSoftKeyboard()); // Type new task title
        onView(withId(R.id.add_task_description)).perform(typeText(description),
                closeSoftKeyboard()); // Type new task description and close the keyboard

        // Save the task
        onView(withId(R.id.fab_edit_task_done)).perform(click());
    }
}
