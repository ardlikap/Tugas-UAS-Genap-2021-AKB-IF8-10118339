package com.example.uas_akb_10118339.view.wisata;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uas_akb_10118339.*;
import com.example.uas_akb_10118339.model.Model;
import com.example.uas_akb_10118339.view.dashboard.DashboardActivity;
import com.example.uas_akb_10118339.view.maps.MapsActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

//13 Agustus 2021, 10118060, Muhammad Al Ardlika Prihasiswana, IF-8
public class WisataActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference database;
    Adapter myAdapter;
    ArrayList<Model> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);

        recyclerView = findViewById(R.id.wisataList);
        database = FirebaseDatabase.getInstance("https://tugas-uas-f8667-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("Wisata");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        myAdapter = new Adapter(this,list);
        recyclerView.setAdapter(myAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Model modelAlam = dataSnapshot.getValue(Model.class);
                    list.add(modelAlam);
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.TempatWisata);

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