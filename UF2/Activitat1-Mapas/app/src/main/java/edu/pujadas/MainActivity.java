package edu.pujadas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button addButton ;
    Button mapButton;

    EditText latitud;
    EditText longitud;
    TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("41531693H");


        addButton = findViewById(R.id.addBtn);
        mapButton = findViewById(R.id.mapBtn);
        latitud = findViewById(R.id.latitud);
        longitud = findViewById(R.id.longitud);

        info= findViewById(R.id.titol);


        SharedPreferences preferences = getSharedPreferences("marcador1",MODE_PRIVATE);
        // he recuperat
        String v1 = preferences.getString("Lat","");
        String v2 = preferences.getString("Long","");

        info.setText(v1);
        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (!latitud.getText().toString().isEmpty() && !longitud.getText().toString().isEmpty())
                {
                    float lat = Float.parseFloat(latitud.getText().toString());
                    float lon = Float.parseFloat(longitud.getText().toString());

                    Toast.makeText(v.getContext(), "El marcador s'ha creat", Toast.LENGTH_SHORT).show();
                }
                latitud.setError("No pot estar vuit");
                longitud.setError("No pot estar vuit");


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