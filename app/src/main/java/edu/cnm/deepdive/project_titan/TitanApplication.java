/*
 *  Copyright 2019 Lance Zotigh, Alex Rauenzahn, Thomas Herrera & Deep Dive Coding
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 * @version 1.0
 * @author Thomas Herrera, Alex Rauenzahn, Lance Zotigh
 */

package edu.cnm.deepdive.project_titan;

import android.app.Application;
import com.facebook.stetho.Stetho;

/**
 * Creates an instance of {@link TitanApplication} and extends Application. Extends {@link
 * Application}, in order to initialize <a href="http://facebook.github.io/stetho/">Stetho</a> *
 * inspection and set up access to this instance via the singleton pattern. At runtime, any instance
 * of an {@link Application} subclass is a de facto singleton; the common {@link #getInstance()} *
 * implementation is used here to enable access to the singleton by other classes in the app.
 */


public class TitanApplication extends Application {

  private static TitanApplication instance = null;

  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;
    Stetho.initializeWithDefaults(this);
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

