package edu.pujadas.eduard_pujadas_act9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity
{
    private TextView marca;
    private TextView model;
    private TextView quant;
    private TextView ruta;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setTitle("Inventari Aula");

        //text views que agafo
        marca = findViewById(R.id.marca);
        model = findViewById(R.id.model);
        quant = findViewById(R.id.quant);
        ruta = findViewById(R.id.ruta);

        /*SharedPreferences preferences = getSharedPreferences("PRODUCTE_DATA",MODE_PRIVATE);


        // recullo amb les preferencies els dades de producte
        String infoMarca= preferences.getString("marca","");
        String infoModel = preferences.getString("model","");
        int quantitat = preferences.getInt("quant",0);
        String rutaImgatge = preferences.getString("img","");

        // afegiexo la informacio en els textes
        marca.setText(infoMarca);
        model.setText(infoModel);
        quant.setText(quantitat);
        ruta.setText(rutaImgatge);*/



    }
}