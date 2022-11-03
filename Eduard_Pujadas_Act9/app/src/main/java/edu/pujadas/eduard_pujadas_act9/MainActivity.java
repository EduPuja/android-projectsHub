package edu.pujadas.eduard_pujadas_act9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Formulari Producte");


        //TODO: mirar que el camp no estigui buit
    }

    /**
     * Metode que utliza el boto de save
     * @param vista
     */
    public void onSaveButon(View vista)
    {

    }

    /**
     * Metode que uilizara el boto de obrir la camara
     * @param vista
     */
    public void onImgButon(View vista)
    {

    }
}