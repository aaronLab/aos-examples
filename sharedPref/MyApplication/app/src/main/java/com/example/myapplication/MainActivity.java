package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /// Preference
    String PREF_NAME = "MyPrefs";
    String PREF_KEY = "imageName";

    /// Edit text
    EditText edit;

    /// Save Button
    Button saveButton;

    /// Load Button
    Button loadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureSaveButton();
        configureLoadButton();
        configureEditText();
        configureSaveButton();
    }

    /// Configures the edit text
    private void configureEditText() {
        edit = (EditText) findViewById(R.id.edit);
        setString();
    }

    /// Configures the save button
    private void configureSaveButton() {
        saveButton = (Button) findViewById(R.id.save);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edit.getText().toString();
                saveText(text);
                edit.setText("");
                Toast.makeText(getApplicationContext(), "Saved!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /// Configures the load button
    private void configureLoadButton() {
        loadButton = (Button) findViewById(R.id.load);

        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setString();
                Toast.makeText(getApplicationContext(), "Loaded!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /// Save text into shared pref
    private void saveText(String text) {
        SharedPreferences sharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(PREF_KEY, text);
        editor.apply();
    }

    /// Load text into the edit text
    private String loadText() {
        SharedPreferences sharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        String storedText = sharedPref.getString(PREF_KEY, "");
        return storedText;
    }

    /// Set String into the edit text
    private void setString() {
        String storedText = loadText();
        edit.setText(storedText);
    }

    @Override
    protected void onStop() {
        super.onStop();

        // When the app blocked...
        String text = edit.getText().toString();
        saveText(text);
    }

}