package com.example.mireysa.ihungry;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


// FavoriteActivity displays a list of user favorites

    public class FavoriteActivity extends AppCompatActivity implements locationFragment.OnFragmentInteractionListener, DetailFragment.OnFragmentInteractionListener {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_favorite);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            locationFragment fragment = new locationFragment();
            fragmentTransaction.add(R.id.fragment_container, fragment);
            fragmentTransaction.commit();


        }

        @Override
        public void onFragmentInteraction(Uri uri) {



        }
    }

