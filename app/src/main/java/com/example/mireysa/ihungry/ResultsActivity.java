package com.example.mireysa.ihungry;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {

    // Displays list of Locations based on user preferences
    ArrayList<listItem> list;
    listAdapter mListAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_results);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Display Results from User Preference
        list = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView);
        mListAdapter = new listAdapter(this);
        listView.setAdapter(mListAdapter);

        // Get Intent Passed
        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            // Receive message value from intent
            String mealMessage = extras.getString("meal");

            // mealMessage serves as query for FetchData
            new FetchData(ResultsActivity.this).execute(mealMessage);
        }
    }

}
