package com.example.android.architecture.blueprints.todoapp.testworksTests;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.Gravity;

import com.example.android.architecture.blueprints.todoapp.Injection;
import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.data.source.TasksDataSource;
import com.example.android.architecture.blueprints.todoapp.tasks.TasksActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.open;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.example.android.architecture.blueprints.todoapp.custom.action.NavigationViewActions.navigateTo;

/**
 * Test Example Seven
 * Add complete test for opening statistics screen and navigating back to To-Do list
 * Now openStatisticsNavView should pass
 */

@RunWith(AndroidJUnit4.class)
public class TestSeven {

    private final static String TESTTITLE = "TEST TITLE";

    private final static String TESTDESCR = "TEST DESCRIPTION";

    private final static String TESTTITLE2 = "SECOND TEST TITLE";

    private final static String TESTDESC2 = "SECOND TEST DESCRIPTION";

    @Rule
    public ActivityTestRule<TasksActivity> mTasksActivityTestRule =
            new ActivityTestRule<TasksActivity>(TasksActivity.class) {

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

    @Test
    public void openStatisticsNavView() {
        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(open()); // Open Drawer

        // Start statistics screen.
        onView(withId(R.id.nav_view))
                .perform(navigateTo(R.id.statistics_navigation_menu_item));

        // Check that Statistics Activity was opened.
        onView(withId(R.id.statistics)).check(matches(isDisplayed()));

        // Open Drawer to click on navigation.
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(open()); // Open Drawer

        // Start tasks list screen.
        onView(withId(R.id.nav_view))
                .perform(navigateTo(R.id.list_navigation_menu_item));

        // Check that Tasks Activity was opened.
        onView(withId(R.id.tasksContainer)).check(matches(isDisplayed()));
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
