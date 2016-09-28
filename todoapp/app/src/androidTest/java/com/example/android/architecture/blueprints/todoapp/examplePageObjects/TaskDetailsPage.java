package com.example.android.architecture.blueprints.todoapp.examplePageObjects;

import com.example.android.architecture.blueprints.todoapp.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Page Object for Task Details page
 */

public class TaskDetailsPage {

    public static void setTaskTitle(String taskTitle) {
        onView(withId(R.id.add_task_title))
                .perform(replaceText(taskTitle), closeSoftKeyboard());
    }

    public static void setTaskDescription (String taskDescription) {
        onView(withId(R.id.add_task_description)).perform(replaceText(taskDescription),
                closeSoftKeyboard());
    }

    public static void clickSaveTask() {
        onView(withId(R.id.fab_edit_task_done)).perform(click());
    }

    public static void clickEditTask() {
        onView(withId(R.id.fab_edit_task)).perform(click());
    }
}
