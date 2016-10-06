package com.example.android.architecture.blueprints.todoapp.tests;

import android.support.test.rule.ActivityTestRule;

import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.tasks.TasksActivity;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class StepOneTest {

    @Rule
    public ActivityTestRule<TasksActivity> mActivityTestRule =
            new ActivityTestRule<TasksActivity>(TasksActivity.class);

    @Test
    public void myFirstExampleTest() {

        onView(withId(R.id.fab_add_task)).perform(click());

    }


}
