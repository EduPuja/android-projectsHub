package edu.pujadas.activitat4_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.*;

import java.util.ArrayList;

import edu.pujadas.activitat4_final.Models.Persona;

public class MainActivity extends AppCompatActivity
{


     EditText  emailFiled;
     EditText passwordFiled;

     ArrayList<Persona> listPersona = new ArrayList<Persona>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailFiled =findViewById(R.id.emailFiled);
        passwordFiled =findViewById(R.id.passwordFiled);


    }

    public void onSendClick(View v)
    {

        if(!emailFiled.getText().toString().isEmpty() && !passwordFiled.getText().toString().isEmpty())
        {

            Persona persona = new Persona(emailFiled.getText().toString(),passwordFiled.getText().toString());

            listPersona.add(persona);
            // preferencias
            SharedPreferences sharedPreferences = getSharedPreferences("USER_INFO",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit(); // editor
            Gson gson= new Gson();

            String jsonPersones =gson.toJson(listPersona);
            editor.putString("listPersona",jsonPersones);
            editor.putBoolean("isRegisterd",true);
            editor.apply();

            if(sharedPreferences.getBoolean("isRegisterd",true))
            {
                //todo canviar de pantalla
                System.out.println("user registerd");
            }

            else
            {
                System.out.println("usuari not registerd");
            }



            /*String correu = listPersona.get(0).getEmail();
            String password = listPersona.get(0).getPassword();
            if(correu.matches(emailFiled.getText().toString()) && password.matches(passwordFiled.getText().toString()))
            {
                System.out.println("nice");
            }
            else
            {
                System.out.println("no");
            }*/
        }
        else
        {
            emailFiled.setError("Correu buit");
            passwordFiled.setError("Password buit");
        }




       /* for(int i=0;i<listPersona.size(); i++)
        {
            if(!listPersona.get(i).getEmail().matches(emailFiled.getText().toString()))
            {
                // preferencias
                SharedPreferences sharedPreferences = getSharedPreferences("USER_INFO",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit(); // editor
                Gson gson= new Gson();

                String jsonProducte =gson.toJson(listPersona);
                editor.putString("listProductes",jsonProducte);
                editor.apply();
            }
            else
            {
                System.out.println("correu repetit");
            }
        }*/



    }
}