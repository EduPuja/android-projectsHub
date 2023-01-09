package edu.pujadas.activitat1;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
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

        Negoci negociCanPaco = new Negoci(1,"Can Paco","restaurant",41.8513,3.1267);
        Negoci mecanic= new Negoci(2,"Garatge Enric","mecanic",41.8484,3.1291);
        Negoci botiga= new Negoci(3,"Botiga Pujadas","mecanic",3.157414, 41.919915);
        Negoci spar= new Negoci(4,"Spar Begur", "botiga",  41.952177, 3.206757);
        Negoci negoci= new Negoci(5,"Spar Begur", "botiga",41.952177, 3.206757);
        Negoci negoci2= new Negoci(6,"Spar Begur", "botiga", 41.952177, 3.206757);
        Negoci negoci3= new Negoci(7,"Spar Begur", "botiga",41.952177, 3.206757);

        listNegocis.add(negociCanPaco);
        listNegocis.add(mecanic);
        listNegocis.add(botiga);
        listNegocis.add(spar);
        listNegocis.add(negoci);
        listNegocis.add(negoci2);
        listNegocis.add(negoci3);
        
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

        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        googleMap.getUiSettings().setZoomGesturesEnabled(true);
        googleMap.getUiSettings().setRotateGesturesEnabled(true);




        // Add a marker in Sydney and move the camera
        //sidney
        //LatLng sydney = new LatLng(-34, 151);

        for(int i =0;i<listNegocis.size();i++)
        {
            LatLng posicion = new LatLng(listNegocis.get(i).getLatitud(),listNegocis.get(i).getLongitud());

            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(posicion);
            markerOptions.title(listNegocis.get(i).getNom());
            if(listNegocis.get(i).getTipusNegoci().equalsIgnoreCase("restaurant"))
            {

                //icono restaruante
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.restaurant));
            }
            else if(listNegocis.get(i).getTipusNegoci().equalsIgnoreCase("botiga"))
            {

                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.tienda));
            }
            else if(listNegocis.get(i).getTipusNegoci().equalsIgnoreCase("mecanic"))
            {
                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.mecanico));

            }

            mMap.addMarker(markerOptions);
        }






    }
}