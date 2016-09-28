package com.example.android.architecture.blueprints.todoapp.toDoPageObjects;

import android.view.Gravity;

import com.example.android.architecture.blueprints.todoapp.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.open;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.example.android.architecture.blueprints.todoapp.custom.action.NavigationViewActions.navigateTo;

/**
 * Page Object for Drawer Menu
 */

public class DrawerMenu {

    private static void openDrawerMenu() {
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT)))
                .perform(open());
    }

    public static void navigateToStatisticsPage() {
        openDrawerMenu();
        onView(withId(R.id.nav_view))
                .perform(navigateTo(R.id.statistics_navigation_menu_item));
    }

    public static void navigateToToDoListPage() {
        openDrawerMenu();
        onView(withId(R.id.nav_view))
                .perform(navigateTo(R.id.list_navigation_menu_item));
    }
}
