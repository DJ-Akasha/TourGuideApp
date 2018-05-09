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
 * {@link PaidAttractionsFragment} interface
 * to handle interaction events.
 * Use the {@link PaidAttractionsFragment} factory method to
 * create an instance of this fragment.
 */
public class PaidAttractionsFragment extends Fragment {

    public PaidAttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Create a list of Market places
        final ArrayList<Places> places = new ArrayList<>();
        // Warner Bros Photo by Rev Stan on Flickr - Licence: https://creativecommons.org/licenses/by/2.0/
        places.add(new Places(getString(R.string.warner_bros_studio_tour), R.string.warner_bros_opening_times, R.string.warner_bros_description, R.drawable.warner_bros, R.string.warner_bros_address));
        // Buckingham Palace Photo by Jordan on Flickr - Licence: https://creativecommons.org/licenses/by-nc-nd/2.0/
        places.add(new Places(getString(R.string.buckingham_palace_tour), R.string.buckingham_palace_opening_times, R.string.buckingham_palace_description, R.drawable.buckingham_palace, R.string.buckingham_palace_address));
        // London Eye Photo by gmacfadyen on Flickr - Licence: https://creativecommons.org/licenses/by-nc-nd/2.0/
        places.add(new Places(getString(R.string.coke_london_eye), R.string.london_eye_opening_times, R.string.london_eye_description, R.drawable.london_eye, R.string.london_eye_address));
        // Madame Tussauds Photo by Tico on Flickr - Licence: https://creativecommons.org/licenses/by-nc-nd/2.0/
        places.add(new Places(getString(R.string.madame_tussauds_museum), R.string.madame_tussauds_opening_times, R.string.madame_tussauds_description, R.drawable.madame_tussauds, R.string.madame_tussauds_address));
        // Sea Life Photo by Bas Boerman on Flickr - try find another if possible - Licence: https://creativecommons.org/licenses/by-nc/2.0/
        places.add(new Places(getString(R.string.sea_life_aquarium), R.string.sea_life_opening_times, R.string.sea_life_description,  R.drawable.sea_life, R.string.sea_life_address));
        // Tower of London Photo by Marc Pether-Longman on Flickr - Licence: https://creativecommons.org/licenses/by-nc-nd/2.0/
        places.add(new Places(getString(R.string.tower_of_london), R.string.tower_of_london_opening_times, R.string.tower_of_london_description, R.drawable.tower_london, R.string.tower_of_london_address));
        // London Dungeon Photo by Óscar del Río on Flickr - Licence: https://creativecommons.org/licenses/by/2.0/
        places.add(new Places(getString(R.string.london_dungeon), R.string.london_dungeon_opening_times, R.string.london_dungeon_description, R.drawable.dungeon, R.string.london_dungeon_address));

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
