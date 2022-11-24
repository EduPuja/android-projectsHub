package edu.pujadas.eduard_pujadas_act9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import edu.pujadas.eduard_pujadas_act9.Adapter.ProducteAdapter;
import edu.pujadas.eduard_pujadas_act9.Models.Producte;

public class SecondActivity extends AppCompatActivity
{
    private  ArrayList<Producte> listProducte = new ArrayList<Producte>();
    private ProducteAdapter producteAdapter;
    private ListView listViewProducte;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setTitle("Inventari productes");

        listViewProducte = findViewById(R.id.producte_list);


        SharedPreferences sharedPreferences = getSharedPreferences("PRODUCTE_DATA",MODE_PRIVATE);
        Gson gson = new Gson();
        String info = sharedPreferences.getString("listProductes","");
        Type type = new TypeToken<ArrayList<Producte>>() {}.getType();
        listProducte = gson.fromJson(info,type);

        /*String marcaSP = sharedPreferences.getString("marca","");
        String modelSP = sharedPreferences.getString("model","");
        String quantitatSP = sharedPreferences.getString("quant","");
        String rutaImg = sharedPreferences.getString("img","");

        Producte producte = new Producte();
        producte.setAllProducte(marcaSP,modelSP,quantitatSP,rutaImg);
        listProducte.add(producte);*/

        producteAdapter = new ProducteAdapter(this, listProducte);
        listViewProducte.setAdapter(producteAdapter);
     

    }


}