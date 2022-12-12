package com.example.activityseven;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StudientProfileActivity extends AppCompatActivity
{
    private TextView email;
    private  TextView dni;
    private TextView telefon;
    private TextView repetidor;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);
        // per agafar el arraylist
        //Bundle extras =  getIntent().getExtras();

        setTitle("Alumne");

        email = findViewById(R.id.email);
        dni=findViewById(R.id.dni);
        telefon=findViewById(R.id.telefon);
        repetidor=findViewById(R.id.repetidor);

        email.setText("alumne@mail.com");
        dni.setText("1234567A");
        telefon.setText("921 231 221");
        repetidor.setText("SI");


        // posar un title amb el nom del alumne i buscar per id cada text view
        // per finalizar fer un set text amb totes les dades
    }

    /**
     * Metode que torna enrere
     * @param vista
     */
    public void onTrunBack(View vista)
    {
        Intent intent = new Intent(this,MainActivity.class);

        startActivity(intent);
    }

}