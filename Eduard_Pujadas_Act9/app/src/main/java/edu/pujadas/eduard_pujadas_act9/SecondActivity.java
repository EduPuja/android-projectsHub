package edu.pujadas.eduard_pujadas_act9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import edu.pujadas.eduard_pujadas_act9.Adapter.ProducteAdapterListView;
import edu.pujadas.eduard_pujadas_act9.Models.Producte;

public class SecondActivity extends AppCompatActivity
{
    private final ArrayList<Producte> listProducte = new ArrayList<Producte>();
    private ProducteAdapterListView producteAdapter;
    private ListView listViewProducte;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setTitle("Inventari productes");

        listViewProducte = findViewById(R.id.producte_list);


        SharedPreferences sharedPreferences = getSharedPreferences("PRODUCTE_DATA",MODE_PRIVATE);
        String marcaSP = sharedPreferences.getString("marca","");
        String modelSP = sharedPreferences.getString("model","");
        String quantitatSP = sharedPreferences.getString("quant","");
        String rutaImg = sharedPreferences.getString("img","");

        Producte producte = new Producte();
        producte.setAllProducte(marcaSP,modelSP,quantitatSP,rutaImg);
        listProducte.add(producte);

        producteAdapter = new ProducteAdapterListView(this, listProducte);
        listViewProducte.setAdapter(producteAdapter);
     

    }
}