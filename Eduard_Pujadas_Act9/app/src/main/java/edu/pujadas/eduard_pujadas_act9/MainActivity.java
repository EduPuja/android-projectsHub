package edu.pujadas.eduard_pujadas_act9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.snackbar.Snackbar;

import edu.pujadas.eduard_pujadas_act9.Models.Producte;

public class MainActivity extends AppCompatActivity
{
    //edit text
    private EditText marcaProducte;
    private EditText modelProducte;
    //spinner
    private Spinner spinner;
    // butons
    private Button saveButon;
    private Button imgButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Formulari Producte");
        marcaProducte=findViewById(R.id.marca_product);
        modelProducte = findViewById(R.id.model_product);

        spinner  = findViewById(R.id.spinner);  //spinner



    }

    /**
     * Metode que utliza el boto de save
     * @param vista
     */
    public void onSaveButon(View vista)
    {


        String infoMarca = marcaProducte.getText().toString();
        String infoModel = modelProducte.getText().toString();

        if(infoMarca.isEmpty())
        {
            marcaProducte.setError("Aquest camp no pot esta buit");
        }
        else if(infoModel.isEmpty())
        {
            modelProducte.setError("Aquest camp no pot esta buit");
        }
        else
        {
            //TODO un cop no esta buit el que se ha de fer es guardar el objecte i passarlo a la segona activity
            Intent intent = new Intent(this,SecondActivity.class);
            Producte producte = new Producte();
            producte.setModelProducte(infoModel);
            producte.setMarcaProducte(infoMarca);
            // quantitat
            // image ?
            startActivity(intent);
        }

    }

    /**
     * Metode que uilizara el boto de obrir la camara
     * @param vista
     */
    public void onImgButon(View vista)
    {
        //todo obrir la camara
    }
}