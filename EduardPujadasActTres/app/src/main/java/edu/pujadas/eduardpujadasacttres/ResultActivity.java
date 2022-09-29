package edu.pujadas.eduardpujadasacttres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class ResultActivity extends AppCompatActivity
{
    TextView resultText;
    Button tryAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //texte per pantalla
        resultText = findViewById(R.id.resultText);
        tryAgain = findViewById(R.id.tryAgain);


        if(isNumberWeek())
        {
            resultText.setText("Correcte!");
            resultText.setTextColor(Color.parseColor("#2CFF06"));

        }
        else
        {


            resultText.setText("Erroni!");
            resultText.setTextColor(Color.parseColor("#FB0000"));
        }



    }

    /**
     * Metode que comprova que el dia de la semana sigui correcte o incorrecte
     * @return
     */

    private boolean isNumberWeek()
    {
        String setmana = getIntent().getStringExtra("numberWeek");


        // instancio el calendari perque sino no se el dia en el que estic actualment
        Calendar calendari = Calendar.getInstance();
        // agafo el numero introduit per el text i el converteix amb numero
        int numSetmanaEntrada = Integer.parseInt(setmana);
        // agafo el calendari i el numero de la semana
        int numSetmana = calendari.get(Calendar.WEEK_OF_YEAR);

        // si son el mateix numero es correcte
        if(numSetmanaEntrada==numSetmana)
        {
            //resultText.setText("Hola");
            return true;
        }
        else
        {
           // resultText.setText("adeu");
            return false;
        }

    }

    /**
     * metode per tornar a enrere
     * @param view
     */
    public void tryAgain(View view)
    {
        Intent result = new Intent(this, currnetWeek.class);
        startActivity(result);

    }


}