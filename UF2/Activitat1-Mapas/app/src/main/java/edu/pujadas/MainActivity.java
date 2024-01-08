package edu.pujadas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity {

    Button addButton ;
    Button mapButton;

    EditText latitud;
    EditText longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("41531693H");


        addButton = findViewById(R.id.addBtn);
        mapButton = findViewById(R.id.mapBtn);
        latitud = findViewById(R.id.latitud);
        longitud = findViewById(R.id.longitud);



        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (!latitud.getText().toString().isEmpty() || !longitud.getText().toString().isEmpty())
                {
                    try {
                        float lat = Float.parseFloat(latitud.getText().toString());
                        float lon = Float.parseFloat(longitud.getText().toString());
                        if (lat < -90 || lat > 90)
                        {
                            Toast.makeText(v.getContext(), "Latitud incorrecte", Toast.LENGTH_SHORT).show();
                        }
                        else if (lon < -180 || lon > 180)
                        {
                            Toast.makeText(v.getContext(), "Longitud incorrecte", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(v.getContext(), "Correcte!", Toast.LENGTH_SHORT).show();
                            SharedPreferences.Editor editor = getSharedPreferences("marcadors", Context.MODE_PRIVATE).edit();


                            editor.putFloat("lat",lat);
                            editor.putFloat("lon",lon);

                        }
                    }
                    catch (Exception e) {
                        Toast.makeText(v.getContext(), "Error!", Toast.LENGTH_SHORT).show();
                    }



                }
                else
                {
                    latitud.setError("No pot estar vuit");
                    longitud.setError("No pot estar vuit");
                }




            }
        });

        mapButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent mapa = new Intent(v.getContext(),MapsActivity.class);
                startActivity(mapa); // inicializar el mapa

            }
        });

    }
}