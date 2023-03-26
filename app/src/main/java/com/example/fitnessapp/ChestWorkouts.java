package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ChestWorkouts extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_workouts);

        recyclerView = findViewById(R.id.recyclerViewWorkouts);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<CategoryData> arrayListBack = new ArrayList<>();
        arrayListBack.add(new CategoryData("Push-ups"));
        arrayListBack.add(new CategoryData("Bench Press"));
        arrayListBack.add(new CategoryData("Chest Flies"));
        arrayListBack.add(new CategoryData("Dips"));

        MyAdapter adapterTwo = new MyAdapter(arrayListBack, ChestWorkouts.this);
        recyclerView.setAdapter(adapterTwo);
    }
}