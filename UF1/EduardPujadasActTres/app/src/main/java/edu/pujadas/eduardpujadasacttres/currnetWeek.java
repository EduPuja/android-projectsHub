package edu.pujadas.eduardpujadasacttres;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;

public class currnetWeek extends AppCompatActivity
{

    EditText numberWeek;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currnet_week);
        numberWeek = findViewById(R.id.numberWeek);
    }

    /**
     * Metode que crida on click
     * @param view
     */
    public void cheackNumber(View view)
    {
        if(numberWeek.getText().toString().trim().equalsIgnoreCase(""))
        {
            numberWeek.setError("Introduce the current week number");
        }
        else
        {
            Intent result = new Intent(this, ResultActivity.class);
            result.putExtra("numberWeek",numberWeek.getText().toString());
            // per passar el intnet de la segona acitivity a la tercera
            startActivity(result);

        }


    }



}


