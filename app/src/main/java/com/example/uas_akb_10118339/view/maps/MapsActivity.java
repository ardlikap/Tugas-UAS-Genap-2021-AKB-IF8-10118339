package com.example.uas_akb_10118339.view.maps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.uas_akb_10118339.databinding.ActivityMapsBinding;
import com.example.uas_akb_10118339.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng latLng = new LatLng(-6.828162, 107.435014);
        mMap.addMarker(new MarkerOptions().position(latLng).title("Marker in Stone Garden"));
        float zoomLevel =  (float) 16.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel));

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                //Creating Marker
                MarkerOptions markerOptions = new MarkerOptions();
                //Set Marker Position
                markerOptions.position(latLng);
                //Set latitude and longtitude on marker
                markerOptions.title(latLng.latitude+ " : " + latLng.longitude);
                //clear the previouslt click
                mMap.clear();
                float zoomLevel =  (float) 16.0f; //This goes up to 21
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,zoomLevel));
                mMap.addMarker(markerOptions);

            }
        });
    }
}