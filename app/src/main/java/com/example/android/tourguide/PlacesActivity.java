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
        Places places = intent.getParcelableExtra("Example Item");

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

                Uri mapUri = Uri.parse("geo:0,0?q=" + Uri.encode(address));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
