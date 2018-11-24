package com.example.vasilii.project_09_arraylistapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    String [] junkFood = {
        "Hamburger",
        "Pizza",
        "Fries",
        "Cheeseburger",
        "Twister",
        "Pepsi"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.foodList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            android.R.layout.simple_expandable_list_item_1,
            junkFood
        );

        listView.setAdapter(adapter);
    }
}
