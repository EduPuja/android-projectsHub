package edu.pujadas.eduard_pujadas_act9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.pujadas.eduard_pujadas_act9.Fragments.FragmentDescripcio;
import edu.pujadas.eduard_pujadas_act9.Fragments.FragmentImage;
import edu.pujadas.eduard_pujadas_act9.Models.Producte;

public class ThirdActivity extends AppCompatActivity
{


   
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        // butons


        //info = findViewById(R.)
        // recullo els intents i els hi poso un valor per defecte :D
        // per poder saber la informacio
        int mac = getIntent().getIntExtra("product",1);
        int screen = getIntent().getIntExtra("product",2);
        int tv = getIntent().getIntExtra("product",3);
        int keyboard = getIntent().getIntExtra("product",4);

        if(mac == 1)
        {
            //ONLY MACS
            setTitle("MACS");
                //aixo es per anara directament a la opcio de macs


        }
        else if(screen ==2 )
        {
            //nomes pantalles
            setTitle("SCREENS");
        }
        else if(tv == 3)
        {
            // nomes televisio
            setTitle("TV");
        }
        else if(keyboard ==4)
        {
            // nomes teclats
            setTitle("KEYBOARDS");
        }


    }

    /**
     * Metode que utiliza el buto de la activitat3
     * @param vista
     */
    public void onImgFragmentBtn(View vista)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.replace(R.id.container_fragment, new FragmentImage()); // replace !!
        fragmentTransaction.commit();
    }

    /**
     * Metode que fa on click buton de descripcio
     * @param vista
     */
    public void onFragmentDescrip(View vista)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.replace(R.id.container_fragment, new FragmentDescripcio()); // replace !!
        fragmentTransaction.commit();
    }
}