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
 */
package edu.cnm.deepdive.project_titan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import edu.cnm.deepdive.project_titan.controller.LoginActivity;
import edu.cnm.deepdive.project_titan.fragments.AchievementsFragment;
import edu.cnm.deepdive.project_titan.fragments.MainScreenFragment;
import edu.cnm.deepdive.project_titan.fragments.NinjaFragment;
import edu.cnm.deepdive.project_titan.service.GoogleSignInService;


/*
  @authors Thomas Herrera, Alex Rauenzahn, Lance Zotigh
 * @version 1.0
 */

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  ProgressBar progressBar;
  private int i = 0;
  private TextView progressTextView;
  private Handler handler = new Handler();


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);


    if (savedInstanceState == null) {
      getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
          new MainScreenFragment()).commit();
    }
    progressBar = (ProgressBar) findViewById(R.id.determinateBar);

    ImageView imgView = (ImageView) findViewById(R.id.image);
    imgView.setImageResource(R.drawable.ninja_drop);


  }

  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    int id = item.getItemId();


    boolean handled = true;
    switch (item.getItemId()) {
      case R.id.sign_out:
        signOut();
        break;
      default:
        handled = super.onOptionsItemSelected(item);
    }
    return handled;
  }

  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    Bundle args = new Bundle();
    switch (item.getItemId()) {
      case R.id.main_screen_fragment:
        loadFragment(new AchievementsFragment(), R.id.fragment_container, "main screen fragment",
            null);// this refers to the method at the very bottom
        break;
      case R.id.achievements_fragment:
        loadFragment(new NinjaFragment(), R.id.fragment_container, "AR Fragment",
            null);// this refers to the method at the very bottom
        break;
      case R.id.ar_model_fragment:
        loadFragment(new MainScreenFragment(), R.id.fragment_container, "fragment3",
            null);// this refers to the method at the very bottom
        break;
    }

    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  public void loadFragment(Fragment fragment, int container, String tag, Bundle args) {
    FragmentManager manager = getSupportFragmentManager();
    if (args != null) {
      fragment.setArguments(args);
    }
    manager.beginTransaction()
        .replace(container, fragment, tag)
//        .addToBackStack(fragment.getClass().getSimpleName())
        .commitNow(); // tag can be specified null and then it will be
  }


  private void signOut() {
    GoogleSignInService.getInstance().getClient().signOut()
        .addOnCompleteListener(this, (task -> {
          GoogleSignInService.getInstance().setAccount(null);
          Intent intent = new Intent(this, LoginActivity.class);
          intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
          startActivity(intent);
        }));
  }


}
