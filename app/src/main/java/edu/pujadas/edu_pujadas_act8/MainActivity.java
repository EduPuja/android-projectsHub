package edu.pujadas.edu_pujadas_act8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Fitxa Producte");
    }

    /**
     * metode que crea la imatge
     * @param vista
     */
    public void onImgButton(View vista)
    {

    }
}