package edu.pujadas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class SecondActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Snackbar mySnackbar = Snackbar.make(findViewById(R.id.layout), "Benvingut Admin", 1000);
        mySnackbar.show();
    }

    public void showSnackbar()
    {
        Snackbar adminSnackbar =  Snackbar.make(findViewById(R.id.layout), "Benvingut Admin", 1000);
        adminSnackbar.show();
    }
}