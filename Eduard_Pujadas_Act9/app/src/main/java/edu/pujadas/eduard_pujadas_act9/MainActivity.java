package edu.pujadas.eduard_pujadas_act9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

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


        //TODO: mirar que el camp no estigui buit
    }

    /**
     * Metode que utliza el boto de save
     * @param vista
     */
    public void onSaveButon(View vista)
    {
        //TODO fer que guant guardi el objecte  producte el passi a l'altre pantalla
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