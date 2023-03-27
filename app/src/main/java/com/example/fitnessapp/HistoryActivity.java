package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    Button btn_add;

    ListView lv;

    EditText et_workout, et_sets, et_reps, et_date;

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    public static ArrayList historyList;


    DbHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Intent intent = getIntent();
        Intent intent_home = new Intent(HistoryActivity.this, MainActivity.class);
        Intent intent_favourites = new Intent(HistoryActivity.this, FavouritesActivity.class);
        Intent intent_login = new Intent(HistoryActivity.this, loginActivity.class);
        drawerLayout = findViewById(R.id.my_drawer_layout);
        NavigationView navView = findViewById(R.id.navbar);
        btn_add = findViewById(R.id.btn_add);
        lv = (ListView) findViewById(R.id.lv_history);



        DB = new DbHelper(this);
        loadListView();

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String itemTitle = item.getTitle().toString();
                if(itemTitle.equals("Home")){
                    startActivity(intent_home);
                }
                if(itemTitle.equals("Favourites"))
                {
                    startActivity(intent_favourites);
                }
                if(itemTitle.equals("Logout"))
                {
                    startActivity(intent_login);
                }
                DrawerLayout drawer = findViewById(R.id.my_drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("long click!", "index: " + i);
                AlertDialog.Builder builder = new AlertDialog.Builder(HistoryActivity.this);
                builder.setTitle("Delete Workout?");
                builder.setMessage("Are you sure you want to delete this workout?");

                builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
                    Object item = historyList.get(i);
                    String[] itemValues = item.toString().split(",");
                    String[] dateValues = itemValues[0].split("=");
                    String[] description = itemValues[1].split("=");

                    String date = dateValues[1];
                    String desc = description[1].replace("}", "");

                    DB.deleteHistory(desc, date);
                    loadListView();
                    dialog.cancel();
                });

                builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                    dialog.cancel();
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(HistoryActivity.this);

                final View customLayout = getLayoutInflater().inflate(R.layout.popup_layout, null);
                builder.setView(customLayout);

                builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        EditText input_weight = customLayout.findViewById(R.id.et_weight);
                        EditText input_workout = customLayout.findViewById(R.id.et_workout);
                        EditText input_sets = customLayout.findViewById(R.id.et_sets);
                        EditText input_reps = customLayout.findViewById(R.id.et_reps);
                        EditText input_date = customLayout.findViewById(R.id.et_date);

                        String description = "Workout: " + input_workout.getText().toString() + "\tSets: "
                                + input_sets.getText().toString() + "\tReps: " + input_reps.getText().toString()
                                + "\tWeight: " + input_weight.getText().toString();
                        String date = input_date.getText().toString();
                        addNewWorkoutHistory(description, date);


                        dialogInterface.cancel();

                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    private void addNewWorkoutHistory(String desc, String date)
    {
        boolean insert = DB.insertWorkouts(MainActivity.getUsername(), desc, date);
        loadListView();
    }

    public void loadListView()
    {
        historyList = DB.displayWorkoutHistory(MainActivity.getUsername());
        ListAdapter adapter = new SimpleAdapter(HistoryActivity.this, historyList, R.layout.history_row, new String[] {"date", "desc"},
                new int[] {R.id.date, R.id.desc});
        lv.setAdapter(adapter);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
