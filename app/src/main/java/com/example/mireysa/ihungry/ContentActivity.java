package com.example.mireysa.ihungry;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

// Content Activity Hosts Multiple Fragments
public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        init();
    }

    private void init() {
        DecisionFragment decisionFragment = new DecisionFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_content_frame, decisionFragment, getString(R.string.tag_decision));
        transaction.addToBackStack(getString(R.string.tag_decision));
        transaction.commit();
    }

}
