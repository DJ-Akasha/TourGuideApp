package com.example.android.tourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by elisasimone on 24/04/2018.
 */

/**
 * {@link PlacesAdapter} is an {@link ArrayAdapter} that can provide the layout for each list based
 * on a data source, which is a list of {@link Places} objects.
 */
public class PlacesAdapter extends ArrayAdapter<Places> {

    /**
     * This is our custom constructor.
     * The context is used to inflate the layout file, and the list is the data we want to populate
     * into the lists.
     * @param context The current context. Used to inflate the layout file.
     * @param places A list of {@link Places} objects to display in a list.
     */
    public PlacesAdapter(Activity context, ArrayList<Places> places){
        // Here, we initialise the ArrayAdapter's internal storage for the context and the list.
        // The second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for an ImageView, the adapter is not going to use the
        //second argument, so it can be any value. Here we use 0.
        super(context, 0, places);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc).
     * @param position      The AdapterView position that is requesting a view.
     * @param convertView   The recycled view to populate.
     * @param parent        The parent ViewGroup that is used for inflation.
     * @return              The view for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view.
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        /** Get the {@link Places} object located at this position in the list */
        Places currentPlace = getItem(position);

        // Find the TextView on the list_item.xml layout with the place_names ID.
        TextView nameOfPlace = listItemView.findViewById(R.id.place_names);
        // Get the place name from the current Places object and set this text on
        // the place_names TextView.
        nameOfPlace.setText(currentPlace.getmNameOfPlace());

        // Find the ImageView on the list_item.xml layout with the image ID.
        ImageView imageView = listItemView.findViewById(R.id.image);

       // If an image is available, display the provided image based on the resource ID.
       imageView.setImageResource(currentPlace.getmImageResourceId());

        // Return the whole list item layout (containing one ImageView and one TextView) so that
        // it can be shown in the ListView.
        return listItemView;
    }
}
