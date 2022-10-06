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

        if(validateUserAdmin())
        {
            //good
            openSecondActivity(vista);
        }
        else
        {
            // mal
            createToast("No ets user ni admin! ");
        }



    }

    protected boolean validateUserAdmin()
    {
        String userInfo = userName.getText().toString();
        String passInfo = paswordInfo.getText().toString();

        if(userInfo.equals("user") && passInfo.equals("1234"))
        {
            return true;
        }
        else if (userInfo.equals("admin") && passInfo.equals("1234"))
        {
            return true;
        }
        else
        {
            return false;
        }


    }

    /**
     * Method that makes a toast / alert whatever you want a call it
     * @param texte
     */
    protected void createToast(String texte)
    {
       //take the context app need for doing a toast
        Context context = getApplicationContext();

        // duaration of a toast
        int duration = Toast.LENGTH_SHORT;
        // crido el tosat i creo un text
        toastCorrect=Toast.makeText(context,texte,duration);
        // showing the toast
        toastCorrect.show();

    }





    /**
     * method to change of activity
     * @param vista
     */
    protected void openSecondActivity(View vista)
    {
        Intent intent = new Intent(this,SecondActivity.class);
        // agafo el valor de usuar
        intent.putExtra("valorUser",0);
        //agafo el valor de admin
        intent.putExtra("valorAdmin",1);
        startActivity(intent);
    }


}