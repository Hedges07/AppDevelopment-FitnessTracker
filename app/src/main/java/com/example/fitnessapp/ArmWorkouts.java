package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.RecoverySystem;

import java.util.ArrayList;

public class ArmWorkouts extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_workouts);

        recyclerView = findViewById(R.id.recyclerViewWorkouts);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<CategoryData> arrayListArms = new ArrayList<CategoryData>();
        arrayListArms.add(new CategoryData("Bicep Curls"));
        arrayListArms.add(new CategoryData("Preacher Curls"));
        arrayListArms.add(new CategoryData("Triceps Pushdown"));
        arrayListArms.add(new CategoryData("Skull Crushers"));
        arrayListArms.add(new CategoryData("Hammer Curls"));

        MyAdapter adapterTwo = new MyAdapter(arrayListArms, ArmWorkouts.this);
        recyclerView.setAdapter(adapterTwo);

    }
}