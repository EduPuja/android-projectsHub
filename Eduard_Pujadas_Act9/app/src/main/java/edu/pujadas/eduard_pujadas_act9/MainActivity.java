package edu.pujadas.eduard_pujadas_act9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.snackbar.Snackbar;

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


        //Snackbar adminSnaback= Snackbar.make(findViewById(R.id.model_product),"Benvingut Admin",1000);


        //adminSnaback.show();

        //TODO: mirar que el camp no estigui buit
    }

    /**
     * Metode que utliza el boto de save
     * @param vista
     */
    public void onSaveButon(View vista)
    {
        //TODO fer que guant guardi el objecte  producte el passi a l'altre pantalla

        //TODO COMPROVAR que el camp no sigui buit

        String infoMarca = marcaProducte.getText().toString();
        if(infoMarca.isEmpty())
        {

        }
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
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