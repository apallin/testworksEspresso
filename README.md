# TestWorks Conf Mobile Automation Workshop
###### Espresso Automation for Android
---

## Steps
---
1. **Create a basic test**
  1. Create a new **Package** called `testWorksTests` under the `androidTest` package at `com.example.android.architecture.blueprints.todoapp`.  This can be done by right clicking on the package folder in the Project View and selecting `New > Package`.
  2. Create a new **Class** in the `testWorksTests` package called `testToDoApp`.  Similar to creating a package, right click on the package folder for `testWorksTests` and select `New > Class`.
  3. In this new class, we will create our first basic espresso test.  The basic skeleton for a test is:
    ```
    @RunWith(AndroidJUnit4.class)
    public class StepOne {

        @Rule
        public ActivityTestRule<TasksActivity> mActivityTestRule =
            new ActivityTestRule<>(TasksActivity.class);

    }
    ```
    Now, once this is in your `testToDoApp` Class, we can start to write a test.
  4. Create a new test method `public void openAddTaskPage()` with an `@Test` annotation.  This test should open the Add Task page by clicking on the [Floating Action Button](https://github.com/apallin/testworksEspresso/blob/master/todoapp/app/src/main/res/layout/tasks_act.xml#L55) and then verify that the [Task Title Edit Text](https://github.com/apallin/testworksEspresso/blob/master/todoapp/app/src/main/res/layout/addtask_frag.xml) field is displayed.  Use basic example on the [web](https://github.com/googlesamples/android-testing/tree/master/ui/espresso/BasicSample), the reference sheets provided.  Remember, you can always look at the completed examples for reference for each step.

2. **Create a test to make a new task**
  1.  Now, expand on the test made in step one to open the task page, fill in a task with a title and description and save the task.

3. **Create a function for making a new task, and create a new test to create a second task**
  1. In the test class, create a new private function for creating a task that should take a string input for both title and description.
  2. After this function is completed, change the original test function for creating a task to use this function.
  3. Create another test to create a second task with a different title and description.
  
4. **Create a test to create a task and edit a task**
  1. This new test should first create a task.  Then, your test should open this newly created task and edit it with a different title and description.
  2. It is recommended, to best illustrate the next step, that you create a task with the same name/description to edit as one of the other tests.  The next step will illustrate set up and teardown procedures regarding test data.  With this step, tasks from other tests will still be present.
  
5. **Create setup step to clear our tasks in-between each test**
  1. Check out the [function](https://github.com/apallin/testworksEspresso/blob/master/todoapp/app/src/androidTest/java/com/example/android/architecture/blueprints/todoapp/exampleTests/StepFive.java#L50) in StepFive for clearing out data.
     ```
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
     ```
  2.  This function uses app code for accessing the data registry to delete all tasks.  This is an important step and illustrates how tests should not be dependent on each other for their data artifacts.
  3.  Leverage this function to explore the code to see how it works and then add it to your tests.  If you were trying to find the task created in Step Four but title and there was duplicate data, causing a headache or failures, this should now work seamlessly.
  
6. **Create a new test for attempting to open the Statistics View by ID**
  1. This test, while seemingly easy in concept, should prove to be difficult.  Try writing the test as such:
     ```
        @Test
        public void openStatisticsNavView() {
            // Open Drawer to click on navigation.
            onView(withId(R.id.drawer_layout))
                    .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                    .perform(open()); // Open Drawer

            // Open Statistics Menu
            onView(withId(R.id.statistics_navigation_menu_item)).perform(click());
        }
     ```
  2.  Because of how this application is structure, this `statistics_navigation_menu_item` cannot be opened just by attempting to click on the ID.  This element is a child of a `DrawerLayout` and a it is part of the Menu.  Therefore, you must work through the actions of finding the menu items and finding the element that way.
  3.  This kind of functionality is not for beginners and therefore this method has been provided for you [here](https://github.com/apallin/testworksEspresso/blob/master/todoapp/app/src/androidTest/java/com/example/android/architecture/blueprints/todoapp/custom/action/NavigationViewActions.java#L63).  However, this is an important step to illustrate that interacting with items is not always as easy trying to click on an item.
  
7. **Using the `navigateTo` function provided, create a test that opens the Statistics View, validates that it is open, then goes back to the Tasks List.**
  1.  Now that we can use the `navigateTo` function provided to open the Statistics View, create a simple test that navigates back and forth from Tasks List, to Statistics, to Tasks List again.
  
8. **Create Page Objects for Pages Touched by Tests Created in Previous Steps**
  1. For best test design practices, it is now time to add a bit of abstraction into what we have already written. Using either our provided [examples](https://github.com/apallin/testworksEspresso/tree/master/todoapp/app/src/androidTest/java/com/example/android/architecture/blueprints/todoapp/examplePageObjects) or this [article](https://newcircle.com/s/post/1772/2015/10/16/tutorial-sustainable-android-tests-with-page-objects) to guide you on creating page objects.
  2.  It is best to create a new Package in `androidTests` to hold your Page Objects to keep test code separated.
  3.  Once you move functions used in tests into these objects, re-write your tests to use these newly created objects.
  
9. **Write your own tests and page objects and explore Espresso!**
  1. Now that you have gotten through the provided examples, you should be able to start writing your own tests!
  2. Examples of tests to write are things like:
    - Complete a created task.
    - Delete a created task.
    - Validate data in the Statistics Page.
