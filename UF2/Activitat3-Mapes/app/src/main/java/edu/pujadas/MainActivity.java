package edu.pujadas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.gms.maps.MapView;

public class MainActivity extends AppCompatActivity {


    MapView mapView;
    Button restaurantBtn, peluqueriaBtn,mecanicBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //find by id
        mapView = findViewById(R.id.mapView);
        restaurantBtn = findViewById(R.id.restaurantBtn);
        peluqueriaBtn = findViewById(R.id.peluqueriaBtn);
        mecanicBtn = findViewById(R.id.mecanicBtn);



    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }
}