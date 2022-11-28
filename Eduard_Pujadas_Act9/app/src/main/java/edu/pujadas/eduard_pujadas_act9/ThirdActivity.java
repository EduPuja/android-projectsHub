package edu.pujadas.eduard_pujadas_act9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ThirdActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        String a =getIntent().getStringExtra("producte");
        if(a.equalsIgnoreCase("1"))
        {
            setTitle("");
        }
        setTitle("3Activity");
    }
}