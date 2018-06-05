package com.example.mireysa.ihungry;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;


// MealActivity serves as the interface to select whether the user desires Breakfast, Lunch, Dinner, etc.

public class MealActivity extends AppCompatActivity {

    private TextView milesDesired;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Find View for Miles
        milesDesired = (TextView) findViewById(R.id.milesChosenTextView);

        // Get Intent Passed
        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            // Receive message value from intent
            String mileMessage = extras.getString("miles");

            // Display message on textView
            milesDesired.setText(mileMessage);
        }


    }
}
