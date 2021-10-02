package com.example.prj9th;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureButtonListener();
    }

    /*
    Button Listener
     */
    private void configureButtonListener() {
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(view -> {
            showDialog("Do you want to pay?", "Cancel", "Confirm");
        });
    }

    /*
    Show Dialog
     */
    private void showDialog(String title,
                            String cancelTitle,
                            String confirmTitle) {
        // Builder
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle(title);

        // Confirm
        alertBuilder.setPositiveButton(confirmTitle, (dialogInterface, i) -> {
            showShortToast("Done!");
        });

        // Cancel
        alertBuilder.setNegativeButton(cancelTitle, (dialogInterface, i) -> {
            showShortToast("Canceled!");
        });

        // Show
        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.show();
    }

    /*
    Create Menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        configureOptionsMenu(menu);
        return super.onCreateOptionsMenu(menu);
    }

    /*
    This will create an inflater with menu in `res - menu - mymenu.xml`
     */
    private void configureOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
    }

    /*
    Show Short Toast
     */
    private void showShortToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    /*
    Show a fruit Toast message
     */
    private void showFruitShortToast(MenuOption menu) {
        String message = String.format("%s pressed.", menu.label);
        showShortToast(message);
    }

    /*
    When Apple menu pressed
     */
    public void applePressed(MenuItem item) {
        showFruitShortToast(MenuOption.APPLE);
    }

    /*
    When Grape menu pressed
     */
    public void grapePressed(MenuItem item) {
        showFruitShortToast(MenuOption.GRAPE);
    }

    /*
    When Banana menu pressed
     */
    public void bananaPressed(MenuItem item) {
        showFruitShortToast(MenuOption.BANANA);
    }
}