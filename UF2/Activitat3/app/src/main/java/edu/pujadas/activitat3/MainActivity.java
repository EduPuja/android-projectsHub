package edu.pujadas.activitat3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    EditText usernameFiled;
    Button btnFollowers;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameFiled.findViewById(R.id.btnFollowers);
        btnFollowers.findViewById(R.id.btnFollowers);
    }

    public void onFollowersClick(View vista)
    {

    }
}