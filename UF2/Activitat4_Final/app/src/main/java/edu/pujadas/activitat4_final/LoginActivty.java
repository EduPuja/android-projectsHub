package edu.pujadas.activitat4_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivty extends AppCompatActivity
{


     EditText  emailFiled;
     EditText passwordFiled;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailFiled =findViewById(R.id.emailFiled);
        passwordFiled =findViewById(R.id.passwordFiled);


    }

    public void onSendClick(View v)
    {

        if(!emailFiled.getText().toString().isEmpty() && !passwordFiled.getText().toString().isEmpty())
        {

            // preferencias
            SharedPreferences sharedPreferences = getSharedPreferences("USER_INFO",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit(); // editor


            //correu persona
            String correu = emailFiled.getText().toString();

            editor.putString("correu",correu);
            editor.putBoolean("isRegisterd",true);
            editor.apply();

            if(sharedPreferences.getBoolean("isRegisterd",true))
            {
            
                System.out.println("user registerd");
                Intent intent = new Intent(this,UserActivity.class);
                startActivity(intent);

            }

            else
            {
                System.out.println("usuari not registerd");
            }




        }
        else
        {
            emailFiled.setError("Correu buit");
            passwordFiled.setError("Password buit");
        }







    }
}