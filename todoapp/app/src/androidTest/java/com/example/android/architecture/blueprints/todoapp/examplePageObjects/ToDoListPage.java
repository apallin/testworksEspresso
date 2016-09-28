package com.example.android.architecture.blueprints.todoapp.examplePageObjects;

import com.example.android.architecture.blueprints.todoapp.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * PageObject for actions on the To-Do list page
 */

public class ToDoListPage {

    public static void checkToDoListActivity() {
        onView(withId(R.id.tasksContainer)).check(matches(isDisplayed()));
    }

    public static void openCreateTask() {
        // Click on the add task button
        onView(withId(R.id.fab_add_task)).perform(click());
    }

    public static void openTaskByTitle(String taskTitle) {
        onView(withText(taskTitle)).perform(click());
    }
}
