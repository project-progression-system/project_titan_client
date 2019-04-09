package edu.cnm.deepdive.project_titan;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * makes a simple test for the Main Activity
 */
@RunWith(AndroidJUnit4.class)
public class SignOutTest {

  @Rule
  public ActivityTestRule<MainActivity> activityRule
      = new ActivityTestRule<>(MainActivity.class);

  //Order matters!!
  @Test
  public void navigateToCompletedAssignmentFragment() {
//
//    //Click on Navigation
//    onView(withId(R.id.))
//        .perform(click());

//    //Click on Navigation
//    onView(withId(R.id.fragment_container))
//        .perform(click());
//
//    //Click on Navigation
//    onView(withId(R.id.completed_assignments_fragment))
//        .perform(click());
  }
}
