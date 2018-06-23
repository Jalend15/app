package com.example.mireysa.ihungry;

import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

// iHungry serves as an app that assists users in finding a location where they would eat depending on their preferences

public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder notification;
    private static final int uniqueID = 45612;
    Button okayButton;
    Dialog welcomeDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);

        // Build the notification
        notification.setSmallIcon(R.drawable.ihungry_logo);
        notification.setTicker("Father's Day is Coming!");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Happy Father's Day");
        notification.setContentText("Explore the best barbecue restuarants nearby to celebrate this Father's Day");

        // Creates Notification Intent
        final Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        // Builds Notification
        NotificationManager nManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nManager.notify(uniqueID, notification.build());

        // Welcome Dialog Box
        welcomeDialog = new Dialog(this);
        welcomeDialog.setContentView(R.layout.welcomedialog);
        welcomeDialog.setTitle("iHungry");

        okayButton = (Button)welcomeDialog.findViewById(R.id.okayButton);
        okayButton.setEnabled(true);

        okayButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                welcomeDialog.cancel();
            }
        });

       welcomeDialog.show();

        // Add Intent to Floating Action Button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Begin Intent
                Intent intent = new Intent(MainActivity.this, ExploreActivity.class);
                startActivity(intent);


            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
