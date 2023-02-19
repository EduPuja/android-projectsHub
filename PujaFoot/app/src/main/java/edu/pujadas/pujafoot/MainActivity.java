package edu.pujadas.pujafoot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

    EditText userName;
    EditText password;

    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("PujaFoot");
        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        submitBtn = findViewById(R.id.submitBtn);

    }

    /**
     * metode onClick que va dirigit al submitBtn
     * @param v vista
     */
    public void onClick(View v)
    {
        if(validateData())
        {
            Intent  intent = new Intent(this, UserActivity.class);
            startActivity(intent);
            // acabo la activity_main perque un cop logejat ja no és necessari tornar a entrar
            finish();
        }

    }

    /**
     * Metode que valida les dades del usuari
     * @return true si es correcte
     */
    private boolean validateData()
    {
        //usuari vuit
        if(userName.getText().toString().isEmpty())
        {
            userName.setError("Introudeix el usuari");

        }
        // password empty
        else if(password.getText().toString().isEmpty())
        {
            password.setError("Introudeix el password");
        }
        else
        {
            // not empty
            if(userName.getText().toString().equalsIgnoreCase("epujadas") && password.getText().toString().equalsIgnoreCase("123asd123"))
                return true;

        }
        return false;
    }
}