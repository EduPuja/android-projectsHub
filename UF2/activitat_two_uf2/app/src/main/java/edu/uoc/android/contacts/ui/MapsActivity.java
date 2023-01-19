package edu.uoc.android.contacts.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import edu.uoc.android.contacts.R;
import edu.uoc.android.contacts.databinding.ActivityMapsBinding;
import edu.uoc.android.contacts.manager.FirebaseContactManager;
import edu.uoc.android.contacts.model.Contact;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback
{

    private GoogleMap mMap;
    private ActivityMapsBinding binding;


    public static Intent makeIntent(Context context)
    {
        return new Intent(context,MapsActivity.class);
    }

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
        mMap = googleMap;
        //tipus mapa
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        //zoom enambled
        mMap.getUiSettings().setZoomControlsEnabled(true);
        // metode per afegir tots els contactes
        contacts();
    }


    /**
     * Metode que utliza el inserta tots els contactes amb una posicio
     */
    public void contacts()
    {

        List<Contact> listContacts= FirebaseContactManager.getInstance().getAllContacts();

        for(int i =0;i<listContacts.size();i++)
        {
            double longitud = listContacts.get(i).getAddress().getLongitude();
            double latitude = listContacts.get(i).getAddress().getLatitude();

            LatLng conactes = new LatLng(latitude, longitud);
            //adiing a marker with a position and title and icon
            mMap.addMarker(new MarkerOptions().position(conactes).title(listContacts.get(i).getName()).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_account_circle_black_24dp)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(conactes));
        }




    }
}