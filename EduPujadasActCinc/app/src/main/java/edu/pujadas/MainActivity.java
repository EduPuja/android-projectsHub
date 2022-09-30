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

        // busca una id que es digui username
        userName = findViewById(R.id.userName);
        // busco per la id la password
        paswordInfo = findViewById(R.id.password);
    }

    /**
     * Metode utilizat onclick buton
     *
     *this method validates if the user that you entry is a admin or a user
     * @param vista
     */
    public void cheackUser(View vista)
    {

    }



}