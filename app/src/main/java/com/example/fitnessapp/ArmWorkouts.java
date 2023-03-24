package com.example.fitnessapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.RecoverySystem;

import java.util.ArrayList;

public class ArmWorkouts extends AppCompatActivity {

    CardView cardView;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_workouts);

        recyclerView = findViewById(R.id.recyclerViewWorkouts);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<ArmData> arrayListArms = new ArrayList<ArmData>();
        arrayListArms.add(new ArmData("Bicep Curls"));
        arrayListArms.add(new ArmData("Preacher Curls"));
        arrayListArms.add(new ArmData("Triceps Push Down"));
        arrayListArms.add(new ArmData("Skull Crushers"));
        arrayListArms.add(new ArmData("Hammer Curls"));

        //MyAdapter adapterTwo = new MyAdapter(arrayListArms, ArmWorkouts.this);


    }
}