package edu.pujadas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class SecondActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViewById(R.id.btn_execute);
        Bundle extras =  getIntent().getExtras();

      if(extras!=null)
      {
          if(extras.getInt("admin") == 1)
          {
              setTitle("Admin");
          }
         else
          {
              setTitle("User");
          }
      }



    }

    /**
     * metode que es cridat en el buto execute
     * @param vista
     */
    public void showSnackbar(View vista)
    {

        Bundle extras =  getIntent().getExtras();

        if(extras!=null)
        {
            if(extras.getInt("admin") == 1)
            {

                Snackbar adminSnaback= Snackbar.make(findViewById(R.id.layout),"Benvingut Admin",1000);
                adminSnaback.show();
            }
            else
            {

                Snackbar userSnackbar= Snackbar.make(findViewById(R.id.layout),"Benvingut user",1000);
                userSnackbar.show();
            }
        }



    }
}