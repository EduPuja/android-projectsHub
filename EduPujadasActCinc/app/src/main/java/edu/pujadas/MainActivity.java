package edu.pujadas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


/**
 * Dades mock
 *
 * user: admin password 1234  ||||| usuari: user pass 1234 
 */
public class MainActivity extends AppCompatActivity
{

    EditText userName;
    EditText paswordInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cheackUser(View vista)
    {

    }



}