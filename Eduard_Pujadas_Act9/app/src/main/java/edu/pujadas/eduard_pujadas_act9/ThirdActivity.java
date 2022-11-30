package edu.pujadas.eduard_pujadas_act9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import edu.pujadas.eduard_pujadas_act9.Fragments.FragmentImage;

public class ThirdActivity extends AppCompatActivity
{

    private TextView info;
    private Button imgButon;
    private Button descrpico;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        // butons
        imgButon = findViewById(R.id.img_buton);
        descrpico = findViewById(R.id.descripButton);

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

            /*FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setReorderingAllowed(true);
            fragmentTransaction.replace(R.id.container_fragment, new FragmentImage()); // replace !!
            fragmentTransaction.commit();*/
           // SecondActivity.listProducte.get(0)
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