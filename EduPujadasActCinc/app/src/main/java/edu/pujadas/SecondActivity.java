package edu.pujadas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class SecondActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }

    public void showSnackbar(View vista)
    {
        Snackbar adminSnackbar =  Snackbar.make(findViewById(R.id.layout), "Benvingut Admin", 1000);
        adminSnackbar.show();
    }
}