package edu.pujadas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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


    MapView mapView ;
    Button restaurantBtn, peluqueriaBtn,mecanicBtn;
    ArrayList<Tienda> listTiendas;
    HashMap<String, Marker> markerHashMap ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // !hasmap the markers

        markerHashMap = new HashMap<String, Marker>();

        //!find by id
        restaurantBtn = findViewById(R.id.restaurantBtn);
        peluqueriaBtn = findViewById(R.id.peluqueriaBtn);
        mecanicBtn = findViewById(R.id.mecanicBtn);
        mapView = findViewById(R.id.mapView);


        mapView.onCreate(savedInstanceState);


        //t!iendas
        Tienda tienda = new Tienda(1,"Can Valdiri", Tipus.RESTAURANT, new LatLng(41.303169,2.003210f));
        Tienda tienda2 = new Tienda(2,"Motos Ferrer", Tipus.MECANIC,new LatLng(41.385063, 2.173404f));
        Tienda tienda3 = new Tienda(3,"Barcelona", Tipus.RESTAURANT,new LatLng(39.569450,2.649950f));
        Tienda tienda4 = new Tienda(4,"Madrid", Tipus.PELUQUERIA,new LatLng(40.416775,-3.703790f));

        listTiendas = new ArrayList<Tienda>();
        //!adding the tiendas
        listTiendas.add(tienda);
        listTiendas.add(tienda2);
        listTiendas.add(tienda3);
        listTiendas.add(tienda4);

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

                for (Tienda t : listTiendas){
                    LatLng posi = t.getPosition();


                    //! variable per posar un tamany a la imatge
                    int alutra = 80;
                    int ancho = 80;

                    if (t.getType() == Tipus.RESTAURANT)
                    {
                        // resutanrat amb el tamany que te la foto
                        Bitmap restaurantIcon = BitmapFactory.decodeResource(getResources(), R.drawable.restaurnat);
                        //restuarnat petit
                        Bitmap tinnyRestaurant = Bitmap.createScaledBitmap(restaurantIcon,alutra,ancho,false);

                        Marker marker = googleMap.addMarker(new MarkerOptions()
                                .position(posi)
                                .title(t.getName())
                                .icon(BitmapDescriptorFactory.fromBitmap(tinnyRestaurant)));
                        googleMap.moveCamera(CameraUpdateFactory.newLatLng(posi));

                        //! add the marker to hasmap
                        markerHashMap.put("restaurant_marker",marker);

                    }
                    else if (t.getType() == Tipus.MECANIC)
                    {
                        Bitmap mecanic = BitmapFactory.decodeResource(getResources(), R.drawable.mecanico);

                        // faig aquest cambi a pettit perque el bitmap de adalt es inmuttable
                        Bitmap tinnyMecanic = Bitmap.createScaledBitmap(mecanic,alutra,ancho,false);

                        Marker marker =googleMap.addMarker(new MarkerOptions()
                                .position(posi)
                                .title(t.getName())
                                .icon(BitmapDescriptorFactory.fromBitmap(tinnyMecanic)));


                        //add the marker to hasmap
                        markerHashMap.put("mecanic_marker",marker);


                    }
                    else if (t.getType() == Tipus.PELUQUERIA){
                        Bitmap pelu = BitmapFactory.decodeResource(getResources(), R.drawable.pelu);

                        //mini pelu
                        Bitmap peluTinny = Bitmap.createScaledBitmap(pelu,alutra,ancho,false);

                        Marker marker = googleMap.addMarker(new MarkerOptions().position(posi).title(t.getName()).icon(BitmapDescriptorFactory.fromBitmap(peluTinny)));

                        //add to the hashmap
                        markerHashMap.put("peluqueria_marker",marker);
                    }


                }

            }


        });






    }


    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }


    public void showRestaurants(View v){
        for( Tienda t : listTiendas)
        {

            if (t.getType() != Tipus.RESTAURANT){
                Marker pelu = markerHashMap.get("peluqueria_marker");
                Marker mecanic = markerHashMap.get("mecanic_marker");

                if (pelu != null && mecanic != null)
                {
                    pelu.setVisible(false);
                    mecanic.setVisible(false);
                }
            }
            else {
                Marker rest = markerHashMap.get("restaurant_marker");
                rest.setVisible(true);
            }


        }
    }

    public void showMecanic(View v){

    }

    public void showPelus(View v){




    }



}