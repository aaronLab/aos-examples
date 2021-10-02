package com.example.prj9th;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    Show a Toast message
     */
    private void showShortToast(MenuOption menu) {
        String message = String.format("%s pressed.", menu.label);
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    /*
    When Apple menu pressed
     */
    public void applePressed(MenuItem item) {
        showShortToast(MenuOption.APPLE);
    }

    /*
    When Grape menu pressed
     */
    public void grapePressed(MenuItem item) {
        showShortToast(MenuOption.GRAPE);
    }

    /*
    When Banana menu pressed
     */
    public void bananaPressed(MenuItem item) {
        showShortToast(MenuOption.BANANA);
    }
}