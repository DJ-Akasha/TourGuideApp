package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlacesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        // This intent is used for the getParcelableExtra so that it allows the movement of data
        Intent intent = getIntent();
        Places places = intent.getParcelableExtra(getString(R.string.example_item));

        String nameOfPlace = places.getmNameOfPlace();
        int daysOpen = places.getmDaysOpen();
        int infoBlurlb = places.getmInfoBlurb();
        int imageResource = places.getmImageResourceId();
       final int physicalAddress = places.getmPhysicalAddress();

        ImageView imageView = findViewById(R.id.image_activity_places);
        imageView.setImageResource(imageResource);

        TextView textViewName = findViewById(R.id.place_names_activity_places);
        textViewName.setText(nameOfPlace);

        TextView textViewBlurb = findViewById(R.id.blurb_activity_places);
        textViewBlurb.setText(infoBlurlb);

        TextView textViewDays = findViewById(R.id.days_open_activity_places);
        textViewDays.setText(daysOpen);

        TextView textViewPhysicalAddress = findViewById(R.id.location_address);
        textViewPhysicalAddress.setText(physicalAddress);
        // When the address is clicked it opens Google Maps to the location
        textViewPhysicalAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String address = getString(physicalAddress);

                Uri mapUri = Uri.parse(getString(R.string.geo_location) + Uri.encode(address));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
                mapIntent.setPackage(getString(R.string.google_maps));
                // Check if the user's phone has an app to handle the implicit intent.
                // If there is no app then the Tour Guide app will not crash thanks to this.
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });
    }
}
