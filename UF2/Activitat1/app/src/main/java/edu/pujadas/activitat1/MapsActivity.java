package edu.pujadas.activitat1;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import edu.pujadas.activitat1.Models.Negoci;
import edu.pujadas.activitat1.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    public  ArrayList<Negoci> listNegocis = new ArrayList<Negoci>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
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
    public void onMapReady(GoogleMap googleMap)
    {
        Negoci negociCanPaco = new Negoci(1,"Can Paco","restaurant",41.8513,3.1267);
        Negoci mecanic= new Negoci(1,"Garatge Enric","mecanic",41.8484,3.1291);

        listNegocis.add(negociCanPaco);
        listNegocis.add(mecanic);

        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        googleMap.getUiSettings().setZoomGesturesEnabled(true);
        googleMap.getUiSettings().setRotateGesturesEnabled(true);
        mMap = googleMap;



        // Add a marker in Sydney and move the camera
        //sidney
        //LatLng sydney = new LatLng(-34, 151);
        LatLng canPaco = new LatLng(listNegocis.get(0).getLatitud(),listNegocis.get(0).getLongitud());

        mMap.addMarker(new MarkerOptions().position(canPaco).title("MARCA CAN PACO").icon());
        mMap.moveCamera(CameraUpdateFactory.newLatLng(canPaco));
    }
}