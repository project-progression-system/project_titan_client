package edu.cnm.deepdive.project_titan;

import android.app.Application;
import com.facebook.stetho.Stetho;

public class TitanApplication extends Application {

  private static TitanApplication instance = null;

  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;
    Stetho.initializeWithDefaults(this); // Comment out this line to disable Stetho.
  }

  /**
   * Returns this instance, for access to application context across the app.
   *
   * @return singleton instance.
   */
  public static TitanApplication getInstance() {
    return instance;
  }

}

