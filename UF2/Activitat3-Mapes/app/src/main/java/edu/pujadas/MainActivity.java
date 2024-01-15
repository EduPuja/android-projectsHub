package edu.pujadas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import edu.pujadas.Models.Tienda;
import edu.pujadas.Models.Tipus;

public class MainActivity extends AppCompatActivity {


    MapView mapView ;
    Button restaurantBtn, peluqueriaBtn,mecanicBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //find by id


        restaurantBtn = findViewById(R.id.restaurantBtn);
        peluqueriaBtn = findViewById(R.id.peluqueriaBtn);
        mecanicBtn = findViewById(R.id.mecanicBtn);


        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);


        //tiendas
        Tienda tienda = new Tienda(1,"Can Valdiri", Tipus.RESTAURANT, new LatLng(41,2.9f));
        Tienda tienda2 = new Tienda(2,"Motos Ferrer", Tipus.MECANIC,new LatLng(41, 2.21f));
        Tienda tienda3 = new Tienda(3,"CCCC", Tipus.RESTAURANT,new LatLng(41,3));

        ArrayList<Tienda> listTiendas = new ArrayList<Tienda>();
        listTiendas.add(tienda);
        listTiendas.add(tienda2);
        listTiendas.add(tienda3);


        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

                for (Tienda t : listTiendas){
                    LatLng posi = t.getPosition();
                    googleMap.addMarker(new MarkerOptions().position(posi).title("hola"));


                }

            }


        });


    }


    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }



}