package com.example.android.architecture.blueprints.todoapp.testworksTests;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.Gravity;

import com.example.android.architecture.blueprints.todoapp.Injection;
import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.data.source.TasksDataSource;
import com.example.android.architecture.blueprints.todoapp.tasks.TasksActivity;
import com.example.android.architecture.blueprints.todoapp.toDoPageObjects.DrawerMenu;
import com.example.android.architecture.blueprints.todoapp.toDoPageObjects.StatisticsPage;
import com.example.android.architecture.blueprints.todoapp.toDoPageObjects.TaskDetailsPage;
import com.example.android.architecture.blueprints.todoapp.toDoPageObjects.ToDoListPage;

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
 * Test Example Eight
 * Refactor Existing Tests into Page Objects
 */

@RunWith(AndroidJUnit4.class)
public class TestEight {

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
        ToDoListPage.openTaskByTitle(TESTTITLE);

        // Click on the edit task button
        TaskDetailsPage.clickEditTask();

        String editTaskTitle = "Edited Title";
        String editTaskDescription = "Edited Description";

        TaskDetailsPage.setTaskTitle(editTaskTitle);
        TaskDetailsPage.setTaskDescription(editTaskDescription);
        TaskDetailsPage.clickSaveTask();

    }

    @Test
    public void openStatisticsNavView() {
        // Start statistics screen.
        DrawerMenu.navigateToStatisticsPage();

        // Check that Statistics Activity was opened.
        StatisticsPage.checkStatisticsActivity();

        // Start tasks list screen.
        DrawerMenu.navigateToToDoListPage();

        // Check that Tasks Activity was opened.
        ToDoListPage.checkToDoListActivity();
    }

    private void createTask(String taskTitle, String taskDescription) {
        ToDoListPage.openCreateTask();

        TaskDetailsPage.setTaskTitle(taskTitle);
        TaskDetailsPage.setTaskDescription(taskDescription);
        TaskDetailsPage.clickSaveTask();
    }
}
