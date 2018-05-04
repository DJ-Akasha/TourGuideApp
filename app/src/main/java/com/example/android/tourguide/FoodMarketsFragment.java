package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 *
 */
public class FoodMarketsFragment extends Fragment {

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FoodMarketsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        final ArrayList<Places> places = new ArrayList<>();
        // Southbank Market Photo by stevekeiretsu on Flickr - Licence: https://creativecommons.org/licenses/by-nc/2.0/
        places.add(new Places("Southbank Centre Market", R.string.southbank_food_market_opening_times, R.string.southbank_food_market_description, R.drawable.southbank_food, R.string.southbank_food_market_address));
        // Borough Market Photo by Herry Lawford on Flickr - Licence: https://creativecommons.org/licenses/by/2.0/
        places.add(new Places("Borough Market", R.string.borough_food_market_opening_times, R.string.borough_food_market_description, R.drawable.borough_market, R.string.borough_food_market_address));
        // Camden Lock Photo by Jorge Franganillo on Flickr - Licence: https://creativecommons.org/licenses/by/2.0/
        places.add(new Places("Camden Food Market", R.string.camden_food_market_opening_times, R.string.camden_food_market_description, R.drawable.camden_food, R.string.camden_food_market_address));
        // Leather Lane Photo by Jim Le on Flickr - Licence: https://creativecommons.org/licenses/by/2.0/
        places.add(new Places("Leather Lane Market", R.string.leather_lane_food_market_opening_times, R.string.leather_lane_food_market_description, R.drawable.leather_lane, R.string.leather_lane_food_market_address));
        // Greenwich Food Market Photo by ellisp on Flickr - Licence: https://creativecommons.org/licenses/by-nc/2.0/
        places.add(new Places("Greenwich Market", R.string.greenwich_food_market_opening_times, R.string.greenwich_food_market_description, R.drawable.greenwich_food, R.string.greenwich_food_market_address));
        // Partridges Market Photo by M@sh on Flickr - Licence: https://creativecommons.org/licenses/by/2.0/
        places.add(new Places("Partridges Food Market", R.string.partridges_food_market_opening_times, R.string.partridges_food_market_description,  R.drawable.partridges_food, R.string.partridges_food_market_address));
        // Dalston Market Photo by michael clarke stuff on Flickr - Licence: https://creativecommons.org/licenses/by/2.0/
        places.add(new Places("Dalston Food Market", R.string.dalston_food_market_opening_times, R.string.dalston_food_market_description, R.drawable.dalston_food, R.string.dalston_food_market_address));
        // Berwick Street Market Photo by Garry Knight on Flickr - Licence: https://creativecommons.org/licenses/by/2.0/
        places.add(new Places("Berwick Street Market", R.string.berwick_food_market_opening_times, R.string.berwick_food_market_description, R.drawable.berwick_food, R.string.berwick_food_market_address));
        // Broadway Market Photo by Christian Lendl on Flickr - Licence: https://creativecommons.org/licenses/by/2.0/
        places.add(new Places("Broadway Market", R.string.broadway_food_market_opening_times, R.string.broadway_food_market_description, R.drawable.broadway_market, R.string.broadway_food_market_address));
        // Maltby Street Market Photo by Matt Brown on Flickr - Licence: https://creativecommons.org/licenses/by/2.0/
        places.add(new Places("Maltby Street Market", R.string.maltby_food_market_opening_times, R.string.maltby_food_market_description, R.drawable.maltby_market, R.string.maltby_food_market_address));
        // Chatsworth Market Photo by Pedro Reyna on Flickr - Licence: https://creativecommons.org/licenses/by/2.0/
        places.add(new Places("Chatsworth Road Market", R.string.chatsworth_food_market_opening_times, R.string.chatsworth_food_market_description,  R.drawable.chatsworth_food, R.string.chatsworth_food_market_address));

        // Create an ArrayAdapter.
        PlacesAdapter adapter = new PlacesAdapter(getActivity(),places);

        // Find the ListView object with the id list which is in the places_list.xml file.
        GridView listView = rootView.findViewById(R.id.list);

        // Makes the ListView use the ArrayAdapter we created above, so that the
        // ListView will display list items for each word in the list of places.
        listView.setAdapter(adapter);

        // setOnItemClickListener so that when user touches a list item it opens in another activity.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), PlacesActivity.class);
                i.putExtra("Example Item", places.get(position));
                startActivity(i);
            }
        });

        return rootView;

    }
}
