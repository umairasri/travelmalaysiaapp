package com.example.travelmalaysia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import com.example.travelmalaysia.fragment.FavouriteFragment;
import com.example.travelmalaysia.fragment.HomeFragment;
import com.example.travelmalaysia.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawLayout;
    BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager;

    DatabaseReference reference;

    Toolbar toolbar;

    // reference for the Firebase Authentication
    private FirebaseAuth mFirebaseAuth;

    // reference for the User in the firebase
    private FirebaseUser mFirebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawLayout.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = findViewById(R.id.navigation_drawer);
        navigationView.setNavigationItemSelectedListener(this);

        bottomNavigationView = findViewById(R.id.bottom_home);
        bottomNavigationView.setBackground(null);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();
                if (itemId == R.id.bottom_home){
                    openFragment(new HomeFragment());
                    return true;
                }
                else if(itemId == R.id.bottom_profile) {
                    openFragment(new ProfileFragment());
                    return true;
                }
                else if(itemId == R.id.bottom_favourite) {
                    openFragment(new FavouriteFragment());
                    return true;
                }
                return false;
            }
        });

        fragmentManager = getSupportFragmentManager();
        openFragment(new HomeFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();
        if(itemId == R.id.nav_list){
            Intent intent = new Intent(MainActivity.this, SearchActivity.class);
            startActivity(intent);
        }
        else if(itemId == R.id.nav_setting){
            Intent intent = new Intent(MainActivity.this, SettingActivity.class);
            startActivity(intent);
        }
        else if(itemId == R.id.nav_logout){
            mFirebaseAuth.signOut();
            Intent intent = new Intent(MainActivity.this, LogInActivity.class);
            startActivity(intent);
        }

        drawLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        if (drawLayout.isDrawerOpen(GravityCompat.START)){
            drawLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();

        }
    }

    private void openFragment(Fragment fragment){

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();

        if (mFirebaseUser == null){

            // go to login page
            Intent intent = new Intent(MainActivity.this, LogInActivity.class);
            startActivity(intent);

        }
    }
}