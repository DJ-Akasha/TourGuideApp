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
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MarketsFragment} interface
 * to handle interaction events.
 * Use the {@link MarketsFragment} factory method to
 * create an instance of this fragment.
 */
public class MarketsFragment extends Fragment {


    public MarketsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Create a list of Market places
        final ArrayList<Places> places = new ArrayList<>();
        // Camden Lock Photo by George Rex on Flickr - Licence: https://creativecommons.org/licenses/by/2.0/
        places.add(new Places(getString(R.string.camden_lock), R.string.camden_market_opening_times, R.string.camden_market_description, R.drawable.camden_lock, R.string.camden_market_address));
        // Portobello Road Photo by George Rex on Flickr - Licence: https://creativecommons.org/licenses/by/2.0/
        places.add(new Places(getString(R.string.portobello), R.string.portobello_market_opening_times, R.string.portobello_market_description, R.drawable.portobello_road, R.string.camden_market_address));
        // Covent Garden Photo by Tredok on Flickr - Licence: https://creativecommons.org/licenses/by/2.0/
        places.add(new Places(getString(R.string.covent_garden), R.string.covent_market_opening_times, R.string.covent_market_description, R.drawable.covent_garden, R.string.covent_market_address));
        // Greenwich Market Photo by Jonathan Cook on Flickr - Licence: https://creativecommons.org/licenses/by/2.0/
        places.add(new Places(getString(R.string.greenwich), R.string.greenwich_market_opening_times, R.string.greenwich_market_description, R.drawable.greenwich_market, R.string.greenwich_market_address));
        // Old Spitalfields Photo by Owen Blacker on Flickr - Licence: https://creativecommons.org/licenses/by/2.0/
        places.add(new Places(getString(R.string.old_spit), R.string.old_spitafields_market_opening_times, R.string.old_spitafields_market_description,  R.drawable.old_spit, R.string.old_spitafields_market_address));
        // Brick Lane Photo by Garry Knight on Flickr - Licence: https://creativecommons.org/licenses/by/2.0/
        places.add(new Places(getString(R.string.brick_lane), R.string.brick_lane_market_opening_times, R.string.brick_lane_market_description, R.drawable.brick_lane, R.string.brick_lane_market_address));
        // Alfie's Antique Market Photo by Rain Rabbit on Flickr - Licence: https://creativecommons.org/licenses/by-nc/2.0/
        places.add(new Places(getString(R.string.alfies), R.string.alfies_antique_market_opening_times, R.string.alfies_antique_market_description, R.drawable.alfies_antique, R.string.alfies_antique_market_address));
        // Colombia Street Flowers Market Photo by Jerome Yewdalll on Flickr - Licence: https://creativecommons.org/licenses/by/2.0/
        places.add(new Places(getString(R.string.columbia), R.string.columbia_market_opening_times, R.string.columbia_market_description,  R.drawable.columbia_market, R.string.columbia_market_address));

        // Create an ArrayAdapter.
        final PlacesAdapter adapter = new PlacesAdapter(getActivity(),places);

        // Find the ListView object with the id list which is in the places_list.xml file.
        final GridView listView = rootView.findViewById(R.id.list);

        // Makes the ListView use the ArrayAdapter we created above, so that the
        // ListView will display list items for each word in the list of places.
        listView.setAdapter(adapter);

        // setOnItemClickListener so that when user touches a list item it opens in another activity.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), PlacesActivity.class);
                i.putExtra(getString(R.string.example_item), places.get(position));
                startActivity(i);
            }
        });

        return rootView;
    }
}
