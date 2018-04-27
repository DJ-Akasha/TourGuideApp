package com.example.android.tourguide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.tourguide.dummy.DummyContent;
import com.example.android.tourguide.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

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
        places.add(new Places("Camden Lock Market", R.string.camden_market_openning_times, R.string.camden_market_description, R.drawable.kevin_grieve_572075_camden));
        places.add(new Places("Portobello Road Market", R.string.portobello_market_openning_times, R.string.portobello_market_description, R.drawable.kevin_grieve_572075_camden));
        places.add(new Places("Covent Garden London", R.string.covent_market_openning_times, R.string.covent_market_description, R.drawable.kevin_grieve_572075_camden));
        places.add(new Places("Greenwich Market", R.string.greenwich_market_openning_times, R.string.greenwich_market_description, R.drawable.kevin_grieve_572075_camden));
        places.add(new Places("Old Spitalfields Market", R.string.old_spitafields_market_openning_times, R.string.old_spitafields_market_description,  R.drawable.kevin_grieve_572075_camden));
        places.add(new Places("Brick Lane Market", R.string.brick_lane_market_openning_times, R.string.brick_lane_market_description, R.drawable.kevin_grieve_572075_camden));
        places.add(new Places("Alfie's Antique Market", R.string.alfies_antique_market_openning_times, R.string.alfies_antique_market_description, R.drawable.kevin_grieve_572075_camden));
        places.add(new Places("Broadway Market", R.string.broadway_market_openning_times, R.string.broadway_market_description, R.drawable.kevin_grieve_572075_camden));
        places.add(new Places("Southbank Centre Market", R.string.southbank_market_openning_times, R.string.southbank_market_description, R.drawable.kevin_grieve_572075_camden));
        places.add(new Places("Maltby Street Market", R.string.maltby_market_openning_times, R.string.maltby_market_description, R.drawable.kevin_grieve_572075_camden));
        places.add(new Places("Columbia Road Flowers", R.string.columbia_market_openning_times, R.string.columbia_market_description,  R.drawable.kevin_grieve_572075_camden));

        PlacesAdapter adapter = new PlacesAdapter(getActivity(),places);

        ListView listView = rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

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
