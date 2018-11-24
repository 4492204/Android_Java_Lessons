package com.example.vasilii.project_10_sportapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SportActivity extends AppCompatActivity {
    public static final String EXTRA_SPORT = "sportId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);

        int sportId = (Integer) getIntent().getExtras().get(EXTRA_SPORT);
        Sport sport = Sport.sports[sportId];

        ImageView imageView = findViewById(R.id.image);
        imageView.setImageResource(sport.getImageResourceId());
        imageView.setContentDescription(sport.getName());

        TextView textViewName = findViewById(R.id.name);
        textViewName.setText(sport.getName());

        TextView textViewDescription = findViewById(R.id.description);
        textViewDescription.setText(sport.getDescription());
    }
}
