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
 * {@link FreeAttractionsFragment} interface
 * to handle interaction events.
 * Use the {@link FreeAttractionsFragment} factory method to
 * create an instance of this fragment.
 */
public class FreeAttractionsFragment extends Fragment {
    public FreeAttractionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.places_list, container, false);

        // Create a list of Market places
        final ArrayList<Places> places = new ArrayList<>();
        // British Museum Photo by Pablo Fernández on Flickr - Licence: https://creativecommons.org/licenses/by-nc-nd/2.0/
        places.add(new Places(getString(R.string.british_museum), R.string.british_museum_opening_times, R.string.british_museum_description, R.drawable.british_museum, R.string.british_museum_address));
        // National Gallery Photo by Maurice on Flickr - Licence: https://creativecommons.org/licenses/by/2.0/
        places.add(new Places(getString(R.string.national_gallery), R.string.national_gallery_opening_times, R.string.national_gallery_description, R.drawable.national_gallery, R.string.national_gallery_address));
        // Tate Modern Photo by Misha Popovikj on Flickr - Licence: https://creativecommons.org/licenses/by-sa/2.0/
        places.add(new Places(getString(R.string.tate_modern), R.string.tate_modern_opening_times, R.string.tate_modern_description, R.drawable.tate, R.string.tate_modern_address));
        // Natural History Museum Photo by neiljs on Flickr - Licence: https://creativecommons.org/licenses/by/2.0/
        places.add(new Places(getString(R.string.natural_history), R.string.natural_history_museum_opening_times, R.string.natural_history_museum_description, R.drawable.natural_history, R.string.natural_history_museum_address));
        // Somerset House Photo by Dave Pearce on Flickr - Licence: https://creativecommons.org/licenses/by-nc-nd/2.0/
        places.add(new Places(getString(R.string.somerset_house), R.string.somerset_house_opening_times, R.string.somerset_house_description,  R.drawable.somerset_house, R.string.somerset_house_address));
        // Science Museum Photo by James F Clay on Flickr - Licence: https://creativecommons.org/licenses/by-nc/2.0/
        places.add(new Places(getString(R.string.science__museum), R.string.science_museum_opening_times, R.string.science_museum_description, R.drawable.science_museum, R.string.science_museum_address));
        // V&A museum Photo by Nick Garrod on Flickr - Licence: https://creativecommons.org/licenses/by-nc-nd/2.0/
        places.add(new Places(getString(R.string.v_and_a__museum), R.string.v_and_a_museum_opening_times, R.string.v_and_a_museum_description, R.drawable.v_and_a_museum, R.string.v_and_a_museum_address));

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
