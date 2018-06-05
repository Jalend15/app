package com.example.mireysa.ihungry;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

// Purpose of MilesActivity is to obtain the desired amount of miles a user wishes to travel

public class MilesActivity extends AppCompatActivity {

    private static final String LOGTAG = "MilesActivity";
    // Seekbar to represent miles
    private SeekBar milesSeekBar;
    // Display current miles selected
    private TextView milesTextView;
    // Confirmation of Miles
    private Button milesConfirmButton;

    int miles = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miles);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Find Views
        milesSeekBar = (SeekBar) findViewById(R.id.mileSeekBar);
        milesTextView = (TextView) findViewById(R.id.mileTextView);
        milesConfirmButton = (Button) findViewById(R.id.confirmMileButton);

        // Set Text to Current Miles
        milesTextView.setText("Miles: " + milesSeekBar.getProgress());

        // Create on Click Listener for SeekBar
        milesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            // When miles value is changed
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                miles = progressValue;
                milesTextView.setText("Miles: " + progressValue);
            }

            // User has started a touch gesture on Seek Bar
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.i(LOGTAG, "Started tracking miles");
            }

            // User has finished a touch gesture on Seek Bar
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                milesTextView.setText("Miles: " + miles);

            }
        });

        milesConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Directs user to next activity:
                Intent intent = new Intent(MilesActivity.this, MealActivity.class);

                // Insert Values to Pass to Next Activity
                intent.putExtra("miles", milesTextView.getText().toString() );

                // Begin Intent
                startActivity(intent);

            }
        });
    }
}
