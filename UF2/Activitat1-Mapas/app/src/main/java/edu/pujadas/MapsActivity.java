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


    /*
        SharedPreferences prefs = getSharedPreferences("marcador",MODE_PRIVATE);
        Gson gson = new Gson(); // per poder recoperar el list de marcadors

        //optain the list of markers from SharedPreferences
        String jsonMarcadors = prefs.getString("list_marcadores","");
        Type type = new TypeToken<ArrayList<LatLng>>() {}.getType();
        ArrayList<LatLng> listMarcadors = gson.fromJson(jsonMarcadors,type);

        for (LatLng m : listMarcadors)
        {
            mMap.addMarker(new MarkerOptions().position(m));
        }*/

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
            //editor 1
            SharedPreferences.Editor editor1 = getSharedPreferences("marcador1", MODE_PRIVATE).edit();
            //editor 2
            SharedPreferences.Editor editor2 = getSharedPreferences("marcador2", MODE_PRIVATE).edit();
            editor1.putString("Lat", "43.8");
            editor1.putString("Long", "13");
            editor1.apply(); // el comit() tambe fa el mateix
            //xina
            editor2.putString("Lat", "41.735320");
            editor2.putString("Long", "2.844690");
            editor1.apply(); // el comit() tambe fa el mateix
            editor2.apply();
            //TODO agafar les shared preferences
        }

        return true;
    }
}