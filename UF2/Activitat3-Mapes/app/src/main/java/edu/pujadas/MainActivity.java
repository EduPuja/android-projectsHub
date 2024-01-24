package edu.pujadas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.pujadas.Models.Tienda;
import edu.pujadas.Models.Tipus;

public class MainActivity extends AppCompatActivity {


    MapView mapView;
    Button restaurantBtn, peluqueriaBtn, mecanicBtn;
    ArrayList<Tienda> listTiendas;
    ArrayList<Marker> listMarkers;

    int altura =80;
    int ancho = 80;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // !hasmap the markers

        listMarkers = new ArrayList<>();

        //!find by id
        restaurantBtn = findViewById(R.id.restaurantBtn);
        peluqueriaBtn = findViewById(R.id.peluqueriaBtn);
        mecanicBtn = findViewById(R.id.mecanicBtn);
        mapView = findViewById(R.id.mapView);

        // afegir la
        mapView.onCreate(savedInstanceState);



        listTiendas = new ArrayList<Tienda>();
        //!adding the tiendas

        listTiendas.add( new Tienda(1, "Motos Ferrer", "mecanic", new LatLng(41.385063, 2.173404f)));
        listTiendas.add(new Tienda(2, "Shusi He", "restaruant", new LatLng(39.569450, 2.649950f)));
        listTiendas.add(new Tienda(3, "Lola Peluqueria", "peluqueria", new LatLng(40.416775, -3.703790f)));
        listTiendas.add(new Tienda(4, "Can Roca", "restaruant", new LatLng(45.971210,4.142880)));
        listTiendas.add(new Tienda(5, "Cotxes Peugot ", "mecanic", new LatLng(44.210,4.143880)));
        listTiendas.add(new Tienda(6, "Mecanic Paco", "mecanic", new LatLng(42.9210,3.148480)));
        listTiendas.add(new Tienda(7, "Higuma", "restaurant", new LatLng(45.410,4.1420)));


        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {


                //restaurant
                restaurantBtn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                    }
                });
               /* for (Tienda t : listTiendas){
                    LatLng posi = t.getPosition();
                    //! variable per posar un tamany a la imatge
                    int alutra = 80;
                    int ancho = 80;

                    if (t.getType().equalsIgnoreCase("restaurant"))
                    {
                        // resutanrat amb el tamany que te la foto
                        Bitmap restaurantIcon = BitmapFactory.decodeResource(getResources(), R.drawable.restaurnat);
                        //restuarnat petit
                        Bitmap tinnyRestaurant = Bitmap.createScaledBitmap(restaurantIcon,alutra,ancho,false);

                        Marker markerRestaurant = googleMap.addMarker(new MarkerOptions()
                                .position(posi)
                                .title(t.getName())
                                .icon(BitmapDescriptorFactory.fromBitmap(tinnyRestaurant)));


                        //! add the marker to arraylist
                        listMarkers.add(markerRestaurant);

                    }
                    else if (t.getType().equalsIgnoreCase("mecanic") )
                    {
                        Bitmap mecanic = BitmapFactory.decodeResource(getResources(), R.drawable.mecanico);

                        // faig aquest cambi a pettit perque el bitmap de adalt es inmuttable
                        Bitmap tinnyMecanic = Bitmap.createScaledBitmap(mecanic,alutra,ancho,false);

                        Marker markerMecanic =googleMap.addMarker(new MarkerOptions()
                                .position(posi)
                                .title(t.getName())
                                .icon(BitmapDescriptorFactory.fromBitmap(tinnyMecanic)));


                        //add the marker to hasmap
                        listMarkers.add(markerMecanic);


                    }
                    else if (t.getType().equalsIgnoreCase("peluqueria")){
                        Bitmap pelu = BitmapFactory.decodeResource(getResources(), R.drawable.pelu);

                        //mini pelu
                        Bitmap peluTinny = Bitmap.createScaledBitmap(pelu,alutra,ancho,false);

                        Marker markerPelu = googleMap.addMarker(new MarkerOptions()
                                .position(posi)
                                .title(t.getName())
                                .icon(BitmapDescriptorFactory.fromBitmap(peluTinny)));

                        //add to the hashmap
                        listMarkers.add(markerPelu);
                    }


                }*/

            }


        });


    }// end on create


    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }










}