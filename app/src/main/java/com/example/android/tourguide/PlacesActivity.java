package com.example.android.tourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlacesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        // This intent is used for the getParcelableExtra
        Intent intent = getIntent();
        Places places = intent.getParcelableExtra("Example Item");

        String nameOfPlace = places.getmNameOfPlace();
        int daysOpen = places.getmDaysOpen();
        int infoBlurlb = places.getmInfoBlurb();
        int imageResource = places.getmImageResourceId();

        ImageView imageView = findViewById(R.id.image_activity_places);
        imageView.setImageResource(imageResource);

        TextView textViewName = findViewById(R.id.place_names_activity_places);
        textViewName.setText(nameOfPlace);

        TextView textViewBlurb = findViewById(R.id.blurb_activity_places);
        textViewBlurb.setText(infoBlurlb);

        TextView textViewDays = findViewById(R.id.days_open_activity_places);
        textViewDays.setText(daysOpen);
    }
}
