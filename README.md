# TestWorks Conf Mobile Automation Workshop
###### Espresso Automation for Android
---

## Steps
---
1. ** Create a basic test **
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
