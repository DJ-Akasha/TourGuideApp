package com.example.android.tourguide;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

/**
 * The {@link MainActivity} is being used as the first activity to be shown.
 * It shows the {@link MarketsFragment} and the {@link FoodMarketsFragment}
 * by using the {@link ViewPager} and {@link MarketsViewPagerAdapter}.
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file.
        setContentView(R.layout.activity_main);

        // Find the view pager that will allow the user to swipe between fragments.
        mViewPager = findViewById(R.id.view_pager);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setting TabLayout (number of tabs = number of ViewPager pages).
        mTabLayout = findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);

        // Set gravity for tab bar
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        // create an adapter that knows which fragment should be shown on each page.
        MarketsViewPagerAdapter adapter = new MarketsViewPagerAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager.
        mViewPager.setAdapter(adapter);
    }
}
