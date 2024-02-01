package edu.pujadas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {




    Button okButton;
    EditText email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences sharedPreferences = getSharedPreferences("info", MODE_PRIVATE);
        String emialPref = sharedPreferences.getString("email","");
        if (!emialPref.isEmpty())
        {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            //find by id
            email = findViewById(R.id.email);
            password =  findViewById(R.id.password);
            okButton = findViewById(R.id.okButton);


            //lisener onlcick
            okButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (email.getText().toString().isEmpty() || password.getText().toString().isEmpty())
                    {
                        email.setError("Camp Vuit");
                        password.setError("Camp Vuit");
                    }
                    else {
                        String emailStr = email.getText().toString();

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("email",emailStr);

                        editor.apply();// save changes

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);


                    }
                }
            });
        }


    }
}