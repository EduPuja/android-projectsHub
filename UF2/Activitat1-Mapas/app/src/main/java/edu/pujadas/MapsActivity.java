package edu.pujadas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import edu.pujadas.databinding.ActivityMapsBinding;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

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
        LatLng palamos = new LatLng(41.846760, 3.128640);
        mMap.addMarker(new MarkerOptions().position(palamos).title("Palamos"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(palamos));
    }


    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.map_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id == R.id.back_menu){

            //editor 1
            SharedPreferences.Editor editor1 = getSharedPreferences("marcador1", MODE_PRIVATE).edit();
            //editor 2
            SharedPreferences.Editor editor2 = getSharedPreferences("marcador2", MODE_PRIVATE).edit();

            editor1.putString("Lat","43.8");
            editor1.putString("Long","13");

            editor1.apply(); // el comit() tambe fa el mateix

            //xina
            editor2.putString("Lat","41.735320");
            editor2.putString("Long","2.844690");

            editor1.apply(); // el comit() tambe fa el mateix
            editor2.apply();

            //TODO agafar les shared preferences





            Intent mainActivity = new Intent(this,MainActivity.class);

            startActivity(mainActivity);
            //finish();
        }
        return true;
    }
}