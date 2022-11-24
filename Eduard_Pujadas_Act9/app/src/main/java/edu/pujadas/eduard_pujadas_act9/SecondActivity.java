package edu.pujadas.eduard_pujadas_act9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    /**
     * Funcio per cridar el menu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflem el menú. Aquesta acció afegeix els items a la barra de acció
        getMenuInflater().inflate(R.menu.menu_inventari, menu);
        return true;
    }

    /**
     * Metode necessesari per poder tenir un menu en la segona activity
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == R.id.showMacs)
        {
            // veure macs
            showMacs();
            return true;
        }
        else if (item.getItemId() == R.id.showScreens)
        {
            //veure pantallas
            showScreens();
            return true;
        }
        else if (item.getItemId() == R.id.showTV)
        {
            //veures televison
            showTv();
            return true;
        }
        else if (item.getItemId() == R.id.showKeyboards)
        {
            //veure teclats
            showKeyboards();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Metode que te envia a la tercera activitat i veus si son macs
     */
    public void showMacs()
    {
        Intent intent = new Intent(this,ThirdActivity.class);
        startActivity(intent);
    }

    /**
     * Metode que te envia a la tercera pantalla i veus les pantalles
     */
    public void showScreens()
    {
        Intent intent = new Intent(this,ThirdActivity.class);
        startActivity(intent);
    }

    /**
     * Metode que te envia a la tercera pantalla i veus les tv
     */
    public void showTv()
    {
        Intent intent = new Intent(this,ThirdActivity.class);
        startActivity(intent);
    }

    /**
     * Metode que te envia a la tercera pantalla i veus les teclats
     */
    public void showKeyboards()
    {
        Intent intent = new Intent(this,ThirdActivity.class);
        startActivity(intent);
    }



}