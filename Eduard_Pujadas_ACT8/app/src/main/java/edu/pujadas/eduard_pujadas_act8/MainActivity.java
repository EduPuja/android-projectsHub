package edu.pujadas.eduard_pujadas_act8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import edu.pujadas.eduard_pujadas_act8.Fragments.FragmentImage;


public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Fitxa Producte");

        // CREACIO DE UN FRAGEMENT
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.add(R.id.container_fragment, new FragmentImage()); // afegiexo !!
        fragmentTransaction.commit();

    }

    /**
     * metode que crea la imatge
     * @param vista
     */
    public void onImgButton(View vista)
    {
        // CREACIO DE UN FRAGEMENT
       /* FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setReorderingAllowed(true);

        // MODIFICIO !!
        fragmentTransaction.replace(R.id.container_fragment, new FragmentImage());
        fragmentTransaction.commit();*/


    }
}