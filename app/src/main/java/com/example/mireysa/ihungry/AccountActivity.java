package com.example.mireysa.ihungry;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AccountActivity extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private EditText mUsername;
    private EditText mPassword;
    private Button btnLogin;
    private CheckBox mCheckbox;
    private Button btnSave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Find Views
        mUsername = (EditText) findViewById(R.id.editTextUsername);
        mPassword = (EditText) findViewById(R.id.editTextPassword);
        mCheckbox = (CheckBox) findViewById(R.id.checkBoxRemember);
        btnLogin = (Button) findViewById(R.id.buttonLogin);
        btnSave = (Button) findViewById(R.id.saveOption);

        // Declaration
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        //Store Shared Preference
        mEditor = mPreferences.edit();

        checkSharedPreference();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Save checkbox preference
                if (mCheckbox.isChecked()) {

                    // Set Checkbox
                    mEditor.putString(getString(R.string.checkbox), "True");
                    mEditor.commit();

                    // Save User's Input for Username
                    String username = mUsername.getText().toString();
                    mEditor.putString(getString(R.string.username), username);
                    mEditor.commit();

                    // Save User's Input for Password
                    String password = mPassword.getText().toString();
                    mEditor.putString(getString(R.string.password), password);
                    mEditor.commit();


                } else {

                    // Set Checkbox
                    mEditor.putString(getString(R.string.checkbox), "False");
                    mEditor.commit();

                    // Save User's Input for Username
                    mEditor.putString(getString(R.string.username), "");
                    mEditor.commit();

                    // Save User's Input for Password
                    mEditor.putString(getString(R.string.password), "");
                    mEditor.commit();

                }
            }
        });

       btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Message = mUsername.getText().toString();
                String file_name = "username_file";

                // Attempt to Save File to Internal Storage
                    try {
                        FileOutputStream fileOutputStream = openFileOutput(file_name, MODE_PRIVATE);
                        try {
                            fileOutputStream.write(Message.getBytes());
                            fileOutputStream.close();
                            Toast.makeText(getApplicationContext(), "Username has been saved to internal storage",Toast.LENGTH_LONG).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }




            }
        });
    }

    // Check Shared Preferences Accordingly
    private void checkSharedPreference() {
        String checkbox = mPreferences.getString(getString(R.string.checkbox), "False");
        String username = mPreferences.getString(getString(R.string.username), "");
        String password = mPreferences.getString(getString(R.string.password), "");

        mUsername.setText(username);
        mPassword.setText(password);

        if(checkbox.equals("True")) {
            mCheckbox.setChecked(true);
        } else {
            mCheckbox.setChecked(false);
        }

    }
}
