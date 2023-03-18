package com.example.fitnessapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TrackerActivity extends AppCompatActivity {

    Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);
        Intent intent = getIntent();


        btn_add = findViewById(R.id.btn_add);

        btn_add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(TrackerActivity.this);
                builder.setView(R.layout.popup_layout);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}