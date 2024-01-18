package edu.pujadas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
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


                    // variable per posar un tamany a la imatge
                    int alutra = 80;
                    int ancho = 80;

                    if (t.getType() == Tipus.RESTAURANT)
                    {
                        // resutanrat amb el tamany que te la foto
                        Bitmap restaurantIcon = BitmapFactory.decodeResource(getResources(), R.drawable.restaurnat);
                        //restuarnat petit
                        Bitmap tinnyRestaurant = Bitmap.createScaledBitmap(restaurantIcon,alutra,ancho,true);

                        googleMap.addMarker(new MarkerOptions().position(posi).title("Restaurant").icon(BitmapDescriptorFactory.fromBitmap(tinnyRestaurant)));


                    }
                    else if (t.getType() == Tipus.MECANIC)
                    {
                        Bitmap mecanic = BitmapFactory.decodeResource(getResources(), R.drawable.mecanico);

                        // faig aquest cambi a pettit perque el bitmap de adalt es inmuttable
                        Bitmap tinnyMecanic = Bitmap.createScaledBitmap(mecanic,alutra,ancho,true);

                        googleMap.addMarker(new MarkerOptions().position(posi).title("Mecanic").icon(BitmapDescriptorFactory.fromBitmap(tinnyMecanic)));

                    }
                    else if (t.getType() == Tipus.PELUQUERIA){
                        Bitmap pelu = BitmapFactory.decodeResource(getResources(), R.drawable.pelu);

                        //mini pelu
                        Bitmap peluTinny = Bitmap.createScaledBitmap(pelu,alutra,ancho,true);

                        googleMap.addMarker(new MarkerOptions().position(posi).title("Peluqueria").icon(BitmapDescriptorFactory.fromBitmap(peluTinny)));
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



}