package com.example.mireysa.ihungry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

// Prompts user whether they wish to select from their favorites or explore a new location by answering questions

public class ExploreActivity extends AppCompatActivity {

    // Directs user to a list, the user composed, of their favorite locations
    private Button visitFavoriteLocationButton;

    // Directs user to MilesActivity to Explore a New Location
    private Button exploreNewPlaceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Find Views
        visitFavoriteLocationButton = findViewById(R.id.visitFavoriteLocationButton);
        exploreNewPlaceButton = findViewById(R.id.exploreLocationButton);

        // Set onClickListeners for Buttons
        exploreNewPlaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Directs user to MilesActivity
                Intent intent = new Intent(ExploreActivity.this, MilesActivity.class);
                startActivity(intent);

            }
        });

        // Set onClickListeners for Buttons
        visitFavoriteLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Directs user to MilesActivity
                Intent intent = new Intent(ExploreActivity.this, FavoriteActivity.class);
                startActivity(intent);

            }
        });
    }
}
