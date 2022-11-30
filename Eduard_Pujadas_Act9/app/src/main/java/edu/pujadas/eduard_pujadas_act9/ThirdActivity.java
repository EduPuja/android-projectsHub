package edu.pujadas.eduard_pujadas_act9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ThirdActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

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
}