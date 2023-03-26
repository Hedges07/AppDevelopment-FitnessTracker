package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class BackWorkouts extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_workouts);

        recyclerView = findViewById(R.id.recyclerViewWorkouts);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<CategoryData> arrayListBack = new ArrayList<>();
        arrayListBack.add(new CategoryData("Pullups"));
        arrayListBack.add(new CategoryData("Lat Pulldown"));
        arrayListBack.add(new CategoryData("Bentover Rows"));
        arrayListBack.add(new CategoryData("Barbell Deadlift"));

        MyAdapter adapterTwo = new MyAdapter(arrayListBack, BackWorkouts.this);
        recyclerView.setAdapter(adapterTwo);
    }
}