package com.example.vasilii.project_03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SeriesList seriesList = new SeriesList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickChoose(View view) {
        TextView textView = findViewById(R.id.series_text);
        Spinner spinner = findViewById(R.id.genre_list);
        String getList = String.valueOf(spinner.getSelectedItem());

        List<String> listTV = seriesList.getListTV(getList);
        StringBuilder listModified = new StringBuilder();

        for (String lists: listTV) {
            listModified.append(lists).append('\n');
        }
        textView.setText(listModified);
    }
}
