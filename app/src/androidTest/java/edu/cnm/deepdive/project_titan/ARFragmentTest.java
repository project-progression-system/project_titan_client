package edu.cnm.deepdive.project_titan;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import android.view.Gravity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * makes a simple test for the Main Activity
 */
@RunWith(AndroidJUnit4.class)
public class ARFragmentTest {

  @Rule
  public ActivityTestRule<MainActivity> activityRule
      = new ActivityTestRule<>(MainActivity.class);

  //Order matters!!
  @Test
  public void navigateToCompletedAssignmentFragment() {

    // Opens the drawer layout
    onView(withId(R.id.drawer_layout))
        .check(matches(isClosed(Gravity.LEFT)))
        .perform(DrawerActions.open());

    // navigates to the completed_assignments_fragment
    onView(withId(R.id.nav_view))
        .perform(NavigationViewActions.navigateTo(R.id.ar_model_fragment));

  }
}