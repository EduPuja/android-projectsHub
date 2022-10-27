package com.example.activityseven;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StudientProfileActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);

        // posar un title amb el nom del alumne i buscar per id cada text view
        // per finalizar fer un set text amb totes les dades
    }

    
    public void onTrunBack(View vista)
    {
        Intent intent = new Intent(this,MainActivity.class);

        startActivity(intent);
    }

}