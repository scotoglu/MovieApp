package com.scoto.moviesapp;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.activity_main_nav_view);
        toolbar = findViewById(R.id.toolbar);
        searchView = findViewById(R.id.search_view);

        this.configurationSearchView();
        this.configurationToolbar();
        this.configurationDrawerLayout();
        this.configurationNavigationView();

    }

    private void configurationSearchView() {
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.setIconified(false);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d(TAG, "onQueryTextChange: Text is: " + newText);
                //TODO --> call filter method or get result
                return true;
            }
        });


    }

    private void configurationToolbar() {
        setSupportActionBar(toolbar);
    }

    private void configurationDrawerLayout() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        toggle.setHomeAsUpIndicator(R.mipmap.hamburger_ic);
        toggle.syncState();
    }

    private void configurationNavigationView() {
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int menuItemId = item.getItemId();

        switch (menuItemId) {
            case R.id.nav_profile:
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                //TODO Profile Fragment
                break;
            case R.id.nav_favorite:
                Toast.makeText(this, "Favorite", Toast.LENGTH_SHORT).show();
                //TODO Favorite Fragment
                break;
            case R.id.nav_mov_lists:
                Toast.makeText(this, "Movie Lists", Toast.LENGTH_SHORT).show();
                //TODO Movie List Fragment
                break;
            case R.id.nav_rated:
                Toast.makeText(this, "Rated", Toast.LENGTH_SHORT).show();
                //TODO Rated Fragment
                break;
            case R.id.nav_settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                //TODO Settings Fragment
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}