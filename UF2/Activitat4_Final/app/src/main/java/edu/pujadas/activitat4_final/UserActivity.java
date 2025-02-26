package edu.pujadas.activitat4_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import edu.pujadas.activitat4_final.Models.Home;
import edu.pujadas.activitat4_final.Models.HomeAdapter;

public class UserActivity extends AppCompatActivity
{

     //arraylist necesarri per informacio de cases per el recicleview
    public static ArrayList<Home> listHomes = new ArrayList<Home>();

     RecyclerView recyclerView;
     HomeAdapter homeAdapter;
     LinearLayoutManager layoutManager;
     Button addHomeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        addHomeBtn =findViewById(R.id.addHomeBtn);

        // metode de les preferencices d'usuari
        preferencies();

        // SI el arraylsit de cases esta buit doncs entra en el metode initData
        if(listHomes.isEmpty())
        {
            initData();
        }
        //metode per afegir al recicleview
        initRecylcerView();

    }


    /**
     * Metode per iniciar les dades falces de cases
     */
    public void initData()
    {

        //creant un objecte casa
        Home homePals= new Home("Pals",BitmapFactory.decodeResource(getBaseContext().getResources(),R.drawable.casaa));
        Home homePalamos= new Home("Palamos",BitmapFactory.decodeResource(getBaseContext().getResources(),R.drawable.casab));
        Home homeCasaC= new Home("Vallobrega",BitmapFactory.decodeResource(getBaseContext().getResources(),R.drawable.casac));
        Home homeCasaD= new Home("Mataró",BitmapFactory.decodeResource(getBaseContext().getResources(),R.drawable.casad));



        listHomes.add(homePals);
        listHomes.add(homePalamos);
        listHomes.add(homeCasaC);
        listHomes.add(homeCasaD);
    }


    /**
     * Metode que agafa el shared prefrences i et posa el titol de la activitat amb nom correu
     * electroinic
     */

    private void preferencies()
    {
        //preferenices USUARI
        SharedPreferences sharedPreferences = getSharedPreferences("USER_INFO",MODE_PRIVATE);
        String correu = sharedPreferences.getString("correu","");
        setTitle("Hello " + correu);

    }

    /**
     * Metode que es utilizat en el onCreate utilzia el recyclerview
     * i posa tot el necessari per poder-lo utilitzar
     */
    private void initRecylcerView()
    {
        //recicleview
        recyclerView = findViewById(R.id.recicleView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        homeAdapter = new HomeAdapter(listHomes);
        recyclerView.setAdapter(homeAdapter);
        //homeAdapter.notifyDataSetChanged();
    }

    /**
     * Metode que utlizes quant cliques el botó addHomeBtn
     *
     * @param vista necesari per el onClick
     */
    public void onAddHomeCick(View vista)
    {
        Intent intent = new Intent(this,AddHomeActivity.class);
        startActivity(intent);

    }
}