package edu.pujadas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
        // prrimer comprovar que hi hagui un usuari o un admin

        if(isUserOrAdmin())
        {
            // activity User / admin  change snapbar?


        }
        else
        {
            // try again
            createToast("No ets ni usuari ni admin");
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
     * Method thats checks if the password is correct if isn't they return false and a toast
     * that says "Password incorrect"
     * @return
     */
    protected boolean isPasswoord()
    {
        //obtinc el nom del edit text i el converteixo amb string
       String  passIntroduced = paswordInfo.getText().toString();
       
        if(passIntroduced.equals("1234"))
        {
            //correcte
            createToast("PASSWORD CORRECTE :D");
            return true;
        }
        else
        {
            createToast("Passowrd incorecte");
            return false;
        }
    }

    /**
     * This method checks if there is a entry in the edit text equals to user that is ok
     * and if in the edit text there is a entry with name admin that returs true as well
     *
     * @return
     */
    protected boolean isUserOrAdmin()
    {
       String infoEditText = userName.getText().toString();
       if(infoEditText.equals("user"))
       {
           // activityUser
           return true;
       }
       else if (infoEditText.equals("admin"))
       {
           // activity admin
           return true;
       }
       else
       {
           // return false
           return false;
       }
    }



}