package com.example.uas_akb_10118339.view.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uas_akb_10118339.R;
import com.example.uas_akb_10118339.view.maps.MapsActivity;
import com.example.uas_akb_10118339.view.wisata.WisataActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

//13 Agustus 2021, 10118060, Muhammad Al Ardlika Prihasiswana, IF-8
public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.ProfileId);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ProfileId:
                        startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.TempatWisata:
                        startActivity(new Intent(getApplicationContext(), WisataActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Maps:
                        startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });
    }
}