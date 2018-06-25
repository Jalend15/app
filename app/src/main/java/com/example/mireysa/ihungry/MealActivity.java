package com.example.mireysa.ihungry;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


// MealActivity serves as the interface to select whether the user desires Breakfast, Lunch, Dinner, etc.

public class MealActivity extends AppCompatActivity {

    private TextView milesDesired;
    private ListView listView;
    private MealAdapter mAdapter;
    String query;
    String meal;

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


        listView = (ListView) findViewById(R.id.mealTypeList);
        final ArrayList<MealType> mealType = new ArrayList<>();

        // Create Meal Types
        mealType.add(new MealType("Breakfast"));
        mealType.add(new MealType("Lunch"));
        mealType.add(new MealType("Dinner"));
        mealType.add(new MealType("Snack"));

        // Set Adapter
        mAdapter = new MealAdapter(this, mealType);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //CustomListItem singleListItem = (CustomListItem) listView.getItemAtPosition(position);
                MealType mItem = (MealType) listView.getItemAtPosition(position);

                // Obtain Meal Type
                meal = mItem.getmealType();

                //Directs user to next activity:
                Intent intent = new Intent(MealActivity.this, ResultsActivity.class);

                // Insert Values to Pass to Next Activity
                intent.putExtra("meal", meal);

                // Begin Intent
                startActivity(intent);
            }
        });

    }


}
