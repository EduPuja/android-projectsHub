package edu.pujadas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class SecondActivity extends AppCompatActivity
{

    //@Override
    protected void onCreate(Bundle savedInstanceState, View vista)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        /*Snackbar mySnackbar = Snackbar.make(vista, "HOla", 2);
        mySnackbar.show();*/
    }
}