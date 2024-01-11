package edu.pujadas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.Gson;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

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

   //Map functionality
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        SharedPreferences pref = getSharedPreferences("mark1",MODE_PRIVATE);
        SharedPreferences pref2 = getSharedPreferences("mark2",MODE_PRIVATE);

        float lat1 = pref.getFloat("lat1",0);
        float lon1 = pref.getFloat("lon1",0);

        //preferecies 2
        float lat2 = pref2.getFloat("lat2",0);
        float lon2 = pref2.getFloat("lon2",0);


        LatLng marker1 = new LatLng(lat1,lon1);
        LatLng marker2 = new LatLng(lat2,lon2);
        mMap.addMarker(new MarkerOptions().position(marker1).title("Origen"));
        mMap.addMarker(new MarkerOptions().position(marker2).title("Desti"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(marker1));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.map_menu, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.tornar) {
            Intent intent = new Intent(this,MainActivity.class);
            //finish();
            startActivity(intent);
        }

        return true;
    }
}