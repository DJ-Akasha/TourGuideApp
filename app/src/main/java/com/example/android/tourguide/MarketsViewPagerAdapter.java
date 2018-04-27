package com.example.android.tourguide;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by elisasimone on 24/04/2018.
 */

/**
 * {@link MarketsViewPagerAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link Places} objects. However,
 * This is only for the {@link MarketsFragment} and {@link FoodMarketsFragment}
 */
public class MarketsViewPagerAdapter extends FragmentPagerAdapter {

    /**
     * The context of the app so that tab names will be displayed as they are strings.
     */
    private Context mContext;

    /**
     * Create a new {@link MarketsViewPagerAdapter} object.
     *
     * @param fragmentManager is the fragment manager that will keep each fragment's state in
     *                        the adapter across swipes.
     */
    public MarketsViewPagerAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        mContext = context;
    }

    /**
     * Returns the {@link Fragment} that should be displayed for the given page number.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new MarketsFragment();
        } else {
            return new FoodMarketsFragment();
        }
    }

    /**
     * Returns the total number of pages.
     */
    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        // Add title based on item position
        if (position == 0) {
            return mContext.getString(R.string.general_markets);
        } else {
            return mContext.getString(R.string.food_markets);
        }
    }
}
