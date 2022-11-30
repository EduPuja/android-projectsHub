package edu.pujadas.eduard_pujadas_act9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ThirdActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
       int[] product = getIntent().getIntArrayExtra("product");
       for(int i =0;i<product.length;i++)
       {
           if(product[i] ==1)
           {
               setTitle("Macs");
           }
           else if(product[i] ==2)
           {
               setTitle("Pantalles");
           }
           else
           {
               setTitle("AAA");
           }
       }


    }
}