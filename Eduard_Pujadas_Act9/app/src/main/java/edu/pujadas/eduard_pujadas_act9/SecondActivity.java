package edu.pujadas.eduard_pujadas_act9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import edu.pujadas.eduard_pujadas_act9.Adapter.ProducteAdapter;
import edu.pujadas.eduard_pujadas_act9.Models.Producte;

public class SecondActivity extends AppCompatActivity
{
    private final ArrayList<Producte> listProducte = new ArrayList<Producte>();
    private ProducteAdapter producteAdapter;
    private ListView listViewProducte;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //titol de la segona atcivity
        setTitle("Inventari Producte");
        // busco en el xml per la id el listView
        listViewProducte = findViewById(R.id.producte_list);
        // llavors creo un adaptador agafant aquesta activitat i el arraylist que creo de producte
        producteAdapter =new ProducteAdapter(this,listProducte);
        // finalment inflo el adaptador
        listViewProducte.setAdapter(producteAdapter);

    }
}