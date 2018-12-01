package com.example.vasilii.project_11_grumpycat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new GrumpyCatAdapter(generateCats());
        recyclerView.setAdapter(adapter);
    }

    private static List<GrumpyCat> generateCats() {
        List<GrumpyCat> grumpyCats = new ArrayList<>();
        grumpyCats.add(new GrumpyCat("Grumpy Cat #1", "https://i.imgur.com/1mV14xZ.jpg"));
        grumpyCats.add(new GrumpyCat("Grumpy Cat #2", "https://i.imgur.com/QXPRUD2.jpg"));
        grumpyCats.add(new GrumpyCat("Grumpy Cat #3", "https://i.imgur.com/Gvy36sZ.jpg"));
        grumpyCats.add(new GrumpyCat("Grumpy Cat #4", "https://i.imgur.com/7D3gkYo.jpg"));
        grumpyCats.add(new GrumpyCat("Grumpy Cat #5", "https://i.imgur.com/5z0CRK8.jpg"));
        grumpyCats.add(new GrumpyCat("Grumpy Cat #6", "https://i.imgur.com/QCoL78q.jpg"));

        return grumpyCats;
    }
}
