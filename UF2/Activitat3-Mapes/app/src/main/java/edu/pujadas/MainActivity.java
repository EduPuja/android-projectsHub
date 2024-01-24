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

    String restaurant = "restaurant";
    String peluqueria = "peluqueria";
    String mecanic = "mecanic";

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

        listTiendas.add( new Tienda(1, "Motos Ferrer",mecanic, new LatLng(41.385063, 2.173404f)));
        listTiendas.add(new Tienda(2, "Shusi He", restaurant, new LatLng(39.569450, 2.649950f)));
        listTiendas.add(new Tienda(3, "Lola Peluqueria", peluqueria, new LatLng(40.416775, -3.703790f)));
        listTiendas.add(new Tienda(4, "Can Roca", restaurant, new LatLng(45.971210,4.142880)));
        listTiendas.add(new Tienda(5, "Cotxes Peugot ", mecanic, new LatLng(44.210,4.143880)));
        listTiendas.add(new Tienda(6, "Mecanic Paco", mecanic, new LatLng(42.9210,3.148480)));
        listTiendas.add(new Tienda(7, "Higuma", restaurant, new LatLng(45.410,4.1420)));
        listTiendas.add(new Tienda(8, "Joaquim Pelus", peluqueria, new LatLng(45.410,4.1420)));
        listTiendas.add(new Tienda(9, "Barberia La Class", peluqueria, new LatLng(36.539000,-4.624350)));
        listTiendas.add(new Tienda(10, "Norauto", mecanic, new LatLng(-32.711100,-4.349861)));
        listTiendas.add(new Tienda(11, "La Gallega", restaurant, new LatLng(32.410,4.10)));


        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {


                //!restaurant
                restaurantBtn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // quant el usuari fagui click al restaurant
                        Bitmap restaurantIcon = BitmapFactory.decodeResource(getResources(), R.drawable.restaurnat);
                        filtrarTienda(restaurant,restaurantIcon,googleMap);



                    }
                });

                //!peluqueria

                peluqueriaBtn.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        Bitmap pelu = BitmapFactory.decodeResource(getResources(), R.drawable.pelu);
                        filtrarTienda(peluqueria,pelu,googleMap);
                    }
                });

                //!mecanic

                mecanicBtn.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {

                        Bitmap mecanicIcon = BitmapFactory.decodeResource(getResources(), R.drawable.mecanico);
                        filtrarTienda(mecanic,mecanicIcon,googleMap);
                    }
                });


            }


        });


    }// end on create


    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }


    /**
     * Metode que el que fa es flitrar les tendes segons el tipus
     * @param tipus String
     * @param icon Imatge
     * @param googleMap googleMap api
     */
    private void filtrarTienda(String tipus,Bitmap icon,GoogleMap googleMap){
        ocultarMarcadores(); // eliminar tots els marcadors
        for (Tienda t : listTiendas){
            if (t.getType().equalsIgnoreCase(tipus))
            {

                // get the position
                LatLng posi = t.getPosition();

                // do the icon more tinny
                Bitmap iconTinny = Bitmap.createScaledBitmap(icon,altura,ancho,false);
                // optain the marker
                Marker marker =googleMap.addMarker(new MarkerOptions()
                        .position(posi)
                        .title(t.getName())
                        .icon(BitmapDescriptorFactory.fromBitmap(iconTinny)));

                // add the marker to the list of markers
                listMarkers.add(marker);

            }
        }


    }

    /**
     * Funcio per ocultar els marcadors
     */
    private void ocultarMarcadores() {
        for (Marker marker : listMarkers) {
            marker.remove();
        }
        listMarkers.clear();
    }









}