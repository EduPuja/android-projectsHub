package edu.pujadas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Dades mock
 *
 * user: admin password 1234  ||||| usuari: user pass 1234
 */
public class MainActivity extends AppCompatActivity
{

    EditText userName;
    EditText paswordInfo;
    Toast toastCorrect;
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
        String userInfo = userName.getText().toString();        // recullo el info del editText de username
        String passInfo = paswordInfo.getText().toString();     // recullo les dades del editext de password
        Intent intent = new Intent(this,SecondActivity.class);

        if(userInfo.equals("user") && passInfo.equals("1234"))
        {
            intent.putExtra("user",0);              // envio el valor del usuari
            startActivity(intent);
        }
        else if (userInfo.equals("admin") && passInfo.equals("1234"))
        {
            intent.putExtra("admin",1);         //envio el valor del admin
            startActivity(intent);
        }
        else
        {
            createToast("No ets user ni admin!");         // informo al usuari / admin que no ha entrat correctament
        }





    }


    /**
     * Method that makes a toast / alert whatever you want a call it
     * @param texte
     */
    protected void createToast(String texte)
    {

        Context context = getApplicationContext();        //take the context app need for doing a toast


        int duration = Toast.LENGTH_SHORT;                 // duaration of a toast
        toastCorrect=Toast.makeText(context,texte,duration);    // crido el tosat i creo un text
        toastCorrect.show();                                    // showing the toast

    }








}