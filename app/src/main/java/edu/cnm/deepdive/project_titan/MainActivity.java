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
import edu.cnm.deepdive.project_titan.controller.LoginActivity;
import edu.cnm.deepdive.project_titan.fragments.AchievementsFragment;
import edu.cnm.deepdive.project_titan.fragments.NinjaFragment;
import edu.cnm.deepdive.project_titan.fragments.Fragment3;
import edu.cnm.deepdive.project_titan.service.GoogleSignInService;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

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

//
//    ImageView imgView = (ImageView) findViewById(R.id.image);
//    imgView.setImageResource(R.drawable.ninja_drop);
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
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
//    if (id == R.id.action_settings) {
//
//      return true;
//    }
    boolean handled = true;
    switch (item.getItemId()) {
      case R.id.sign_out:
        signOut();
        break;
      default:
        handled = super.onOptionsItemSelected(item);
    }
    return handled;
//    return super.onOptionsItemSelected(item);
  }

  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
    Bundle args = new Bundle();
    Fragment fragment = null;
    switch (item.getItemId()) {
      case R.id.fragment_1:
        fragment = new AchievementsFragment();
        loadFragment(fragment, R.id.fragment_container, fragment.getClass().getSimpleName(),
            null);// this refers to the method at the very bottom
        break;
      case R.id.fragment_2:
        fragment = new NinjaFragment();
        loadFragment(fragment, R.id.fragment_container, fragment.getClass().getSimpleName(),
            null);// this refers to the method at the very bottom
        break;
      case R.id.fragment_3:
        fragment = new Fragment3();
        loadFragment(fragment, R.id.fragment_container, fragment.getClass().getSimpleName(),
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
