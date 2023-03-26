package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class LegWorkouts extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leg_workouts);

        recyclerView = findViewById(R.id.recyclerViewWorkouts);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<CategoryData> arrayListBack = new ArrayList<>();
        arrayListBack.add(new CategoryData("Squats"));
        arrayListBack.add(new CategoryData("Hamstring Curls"));
        arrayListBack.add(new CategoryData("Leg Press"));
        arrayListBack.add(new CategoryData("Calf Raises"));
        arrayListBack.add(new CategoryData("Leg Extensions"));

        MyAdapter adapterTwo = new MyAdapter(arrayListBack, LegWorkouts.this);
        recyclerView.setAdapter(adapterTwo);
    }
}