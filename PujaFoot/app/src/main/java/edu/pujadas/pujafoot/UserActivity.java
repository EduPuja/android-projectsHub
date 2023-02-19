package edu.pujadas.pujafoot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class UserActivity extends AppCompatActivity
{

    RecyclerView productesRView;
    // adapter
    //layout manager


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        setTitle("Llistat de Prodcutes");
    }
}