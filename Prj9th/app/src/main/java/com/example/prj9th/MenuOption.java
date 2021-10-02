package com.example.prj9th;

/*
This enum represents Menu Options
 */
public enum MenuOption {

    APPLE("Apple"),
    GRAPE("Grape"),
    BANANA("Banana");

    public final String label;

    MenuOption(String label) {
        this.label = label;
    }
}
