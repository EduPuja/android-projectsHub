package edu.pujadas.pujafoot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserActivity extends AppCompatActivity
{

    RecyclerView productesRView;
    // adapter
    //layout manager

   //todo poner un recyclerView amb adapter i layoutManager ... and per ultim un arraylist que pugui insertar dades al recyclerView

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        setTitle("Llistat de Prodcutes");
    }


    public void onAddClick(View v)
    {
        Intent  intent = new Intent(this, AddProductActivity.class);
        startActivity(intent);
    }

    public void onClearClcick(View v)
    {
        //todo clear the arraylist
    }
}