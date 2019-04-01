package edu.cnm.deepdive.project_titan;

import android.app.Application;
import com.facebook.stetho.Stetho;

public class TitanApplication extends Application {

  private static TitanApplication instance = null;

  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;
    Stetho.initializeWithDefaults(this);
  }


  public static TitanApplication getInstance() {
    return instance;
  }

}

