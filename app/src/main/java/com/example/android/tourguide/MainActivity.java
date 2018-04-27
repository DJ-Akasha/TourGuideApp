package com.example.android.tourguide;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * The {@link MainActivity} is being used as the first activity to be shown.
 * It shows the {@link MarketsFragment} and the {@link FoodMarketsFragment}
 * by using the {@link ViewPager} and {@link MarketsViewPagerAdapter}.
 */
public class MainActivity extends AppCompatActivity {

    /** Navigation Drawer code found in several places
     * Author Chike Mgbemena, 19 Jan 2018 -
     * https://code.tutsplus.com/tutorials/how-to-code-a-navigation-drawer-in-an-android-app--cms-30263
     * https://developer.android.com/training/implementing-navigation/nav-drawer.html
     * */

    //NEW
    private DrawerLayout drawer;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file.
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments.
        viewPager = findViewById(R.id.view_pager);

        //NEW
        Toolbar toolbar = findViewById(R.id.toolbar);
        //NEW
        drawer = findViewById(R.id.drawer_layout);
        //NEW
        setSupportActionBar(toolbar);

        //NEW
        //create default navigation drawer toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //NEW
        // Setting TabLayout (number of tabs = number of ViewPager pages).
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        //NEW
        // Set gravity for tab bar
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //NEW
        // Handling navigation view item event
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                drawer.closeDrawers();

                // Add code here to update the UI based on the item selected
                // For example, swap UI fragments here

                return true;
            }
        });

        // create an adapter that knows which fragment should be shown on each page.
        MarketsViewPagerAdapter adapter = new MarketsViewPagerAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager.
        viewPager.setAdapter(adapter);


        //NEW
/*        @Override
        public void onBackPressed() {
            assert drawer != null;
            if (drawer.isDrawerOpen(GravityCompat.START)){
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }*/
    }
// NEW
/*    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.fr1) {
            viewPager.setCurrentItem(0);
        } else if (id == R.id.fr2) {
            viewPager.setCurrentItem(1);
        } else if (id == R.id.fr3) {
            viewPager.setCurrentItem(2);
        } else if (id == R.id.close) {
            finish();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/

}
