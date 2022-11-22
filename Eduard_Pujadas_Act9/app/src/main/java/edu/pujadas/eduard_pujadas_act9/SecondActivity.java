package edu.pujadas.eduard_pujadas_act9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import edu.pujadas.eduard_pujadas_act9.Adapter.ProducteAdapter;
import edu.pujadas.eduard_pujadas_act9.Models.Producte;

public class SecondActivity extends AppCompatActivity
{
    // texts view que son per fer un set
    private TextView marca;
    private TextView model;
    private TextView quant;
    //private TextView ruta;


    private final ArrayList<Producte> listProductes =new ArrayList<>();
    private ProducteAdapter producteAdapter;
    private ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setTitle("Inventari Aula");

        // lsitView
        listView = findViewById(R.id.producte_list_view);

        //adaptador
        producteAdapter = new ProducteAdapter(this,listProductes);


        //text views que agafo

       // ruta = findViewById(R.id.ruta);


        SharedPreferences preferences = getSharedPreferences("PRODUCTE_DATA",MODE_PRIVATE);
        String infoMarca = preferences.getString("marca","");
        String infoModel = preferences.getString("model","");
        String infoQuant = preferences.getString("quant","");
        String infoRuta = preferences.getString("img","");




        /*marca.setText(infoMarca);
        model.setText(infoModel);
        quant.setText(infoQuant);
       // ruta.setText(infoRuta);*/

        listView.setAdapter(producteAdapter);
    }
}