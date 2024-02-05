package edu.pujadas.finalapp;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import edu.pujadas.finalapp.adapter.MarkerAdapater;
import edu.pujadas.finalapp.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    List<Marker> listMarkers ;

    MarkerAdapater adapater;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        listMarkers = new ArrayList<Marker>();







    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng a = new LatLng(42, 2.213);
        LatLng b = new LatLng(40, 3.213);
        LatLng c = new LatLng(41, 4.213);
        LatLng d = new LatLng(40, -2.213);


       Marker aM= mMap.addMarker(new MarkerOptions().position(a).title("A"));
        Marker bM = mMap.addMarker(new MarkerOptions().position(b).title("B"));
        Marker cM = mMap.addMarker(new MarkerOptions().position(c).title("C"));
        Marker dM = mMap.addMarker(new MarkerOptions().position(d).title("D"));

        listMarkers.add(aM);
        listMarkers.add(bM);
        listMarkers.add(cM);
        listMarkers.add(dM);


        mMap.moveCamera(CameraUpdateFactory.newLatLng(a));

        initRecylcerView();
    }


    private void initRecylcerView()
    {
        //recicleview
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapater = new MarkerAdapater(listMarkers);
        recyclerView.setAdapter(adapater);
        //homeAdapter.notifyDataSetChanged();
    }
}