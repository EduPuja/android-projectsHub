package edu.pujadas.activitat4_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

public class AddHomeActivity extends AppCompatActivity
{
    static final int REQUEST_VIDEO_CAPTURE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_home);

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
}