package edu.cnm.deepdive.project_titan;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

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
  public void navigateToCompletedAssignmentFragment() throws InterruptedException {

    //Click on Navigation
    onView(withId(R.id.action_notification1))
        .perform(click());

    Thread.sleep(2000);

    //Click on Navigation
    onView(withText("Sign out"))
        .perform(click());
  }
}
