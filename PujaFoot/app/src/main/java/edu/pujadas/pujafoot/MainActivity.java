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

    public void onClick(View v)
    {
        if(validateData())
        {
            Intent  intent = new Intent(this, UserActivity.class);
            startActivity(intent);
            finish();
        }


    }

    public boolean validateData()
    {
        if(userName.getText().toString().isEmpty())
        {
            userName.setError("Introudeix el usuari");

        }
        else if(password.getText().toString().isEmpty())
        {
            password.setError("Introudeix el password");
        }
        else
        {
            if(userName.getText().toString().equalsIgnoreCase("epujadas") && password.getText().toString().equalsIgnoreCase("123asd123"))
                return true;

        }
        return false;
    }
}