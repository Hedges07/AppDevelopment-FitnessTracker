package com.example.fitnessapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    CardView cardView;
    RecyclerView recyclerView;

    public static String username;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();

        if(intent.hasExtra("userID"))
        {
            username = intent.getStringExtra("userID");
        }

        RecyclerView recycler = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        ArrayList<CategoryData> arrayList = new ArrayList<>();
        arrayList.add(new CategoryData("Arms"));
        arrayList.add(new CategoryData("Legs"));
        arrayList.add(new CategoryData("Back"));
        arrayList.add(new CategoryData("Chest"));

        MyAdapter adapter = new MyAdapter(arrayList, MainActivity.this);
        recycler.setAdapter(adapter);

        Intent intent_favorite = new Intent(MainActivity.this, FavouritesActivity.class);
        Intent intent_history = new Intent(MainActivity.this, HistoryActivity.class);

        drawerLayout = findViewById(R.id.my_drawer_layout);
        NavigationView navView = findViewById(R.id.navbar);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String itemTitle = item.getTitle().toString();
                if(itemTitle.equals("Favourites")){
                    startActivity(intent_favorite);
                }
                if(itemTitle.equals("Workout History"))
                {
                    startActivity(intent_history);
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

    public static String getUsername(){
        return username;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}