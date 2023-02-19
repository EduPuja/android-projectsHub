package edu.pujadas.pujafoot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AddProductActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        setTitle("Add Product");
    }
}