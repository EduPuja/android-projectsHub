package edu.pujadas.activitat3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.pujadas.activitat3.rest.model.Owner;

public class MainActivity extends AppCompatActivity
{
    EditText usernameFiled;
    Button btnFollowers;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameFiled =findViewById(R.id.usernameFiled);
        btnFollowers = findViewById(R.id.btnFollowers);
    }

    public void onFollowersClick(View vista)
    {
        if(usernameFiled.getText().toString().isEmpty())
        {
            usernameFiled.setError("Username Empty");
        }
        else
        {
            Intent intent = new Intent(MainActivity.this, FollowersActivity.class);
            intent.putExtra("nomUsuari",usernameFiled.getText().toString());
            startActivity(intent);
        }

    }
}