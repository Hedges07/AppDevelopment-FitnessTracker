package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class FavouritesActivity extends AppCompatActivity {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);
        Intent intent = getIntent();
        Intent intent_home = new Intent(FavouritesActivity.this, MainActivity.class);
        Intent intent_history = new Intent(FavouritesActivity.this, HistoryActivity.class);
        Intent intent_login = new Intent(FavouritesActivity.this, loginActivity.class);
        drawerLayout = findViewById(R.id.my_drawer_layout);
        NavigationView navView = findViewById(R.id.navbar);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String itemTitle = item.getTitle().toString();
                if(itemTitle.equals("Home")){
                    startActivity(intent_home);
                }
                if(itemTitle.equals("Workout History"))
                {
                    startActivity(intent_history);
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


    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
