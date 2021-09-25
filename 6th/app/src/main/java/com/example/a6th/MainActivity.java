package com.example.a6th;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // When the button is pressed
    public void onPressed(View view) {
        Toast.makeText(getApplicationContext(), "Button Pressed", Toast.LENGTH_SHORT).show();
    }
}