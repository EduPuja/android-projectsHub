package edu.pujadas.activitat4_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Random;

import edu.pujadas.activitat4_final.Models.Home;

public class AddHomeActivity extends AppCompatActivity
{
    static final int REQUEST_VIDEO_CAPTURE = 1;
    EditText nameCity;
    Button openCamera;
    Button insertHome;
    ArrayList<Home> listHomes = new ArrayList<Home>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_home);
        nameCity = findViewById(R.id.nameCity);
        openCamera = findViewById(R.id.openCamera);
        insertHome = findViewById(R.id.insertHome);
        setTitle("Add Home");
    }

    public void openCamera(View vista)
    {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try
        {
            startActivityForResult(takePictureIntent, REQUEST_VIDEO_CAPTURE);

        }
        catch (ActivityNotFoundException e)
        {
                // display error state to the user
            e.printStackTrace();
        }

    }

    public void insertOne(View vista)
    {
        if(!nameCity.getText().toString().isEmpty())
        {



            Home home= new Home(nameCity.getText().toString(), BitmapFactory.decodeResource(getBaseContext().getResources(),R.drawable.casab));

            UserActivity.listHomes.add(home);

            /*listHomes.add(home);
            System.out.println("Home inserted");*/


            Intent intent = new Intent(this,UserActivity.class);
            startActivity(intent);

        }
        else
        {
            nameCity.setError("Name Empty");
        }

    }
}