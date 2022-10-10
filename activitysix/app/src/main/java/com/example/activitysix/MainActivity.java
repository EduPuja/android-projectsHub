package com.example.activitysix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    // Request code
    private final int REQUEST_PERMISSION_STORAGE_SAVE = 101;
    private final int REQUEST_PERMISSION_STORAGE_DELETE = 102;
    static final int REQUEST_VIDEO_CAPTURE = 1;
    // Views
    private Button buttonOpenImage;
    @SuppressWarnings("FieldCanBeLocal")
    private ImageView imageView;
    @SuppressWarnings("FieldCanBeLocal")
    private TextView tvMessage;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set views
        buttonOpenImage = findViewById(R.id.btn_capture);
        imageView = findViewById(R.id.image_app);
        tvMessage = findViewById(R.id.image_message);

        // Set listeners
        buttonOpenImage.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == R.id.action_delete)
        {
            onDeleteMenuTap();
            return true;
        } else if (item.getItemId() == R.id.action_save)
        {
            onSaveMenuTap();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void onDeleteMenuTap()
    {
        // check permissions
        if (!hasPermissionsToWrite())
        {
            // request permissions
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_PERMISSION_STORAGE_DELETE);
        }
        else
        {
            // TODO: show dialog if image file exists
        }
    }

    private void onSaveMenuTap()
    {
        // check permissions
        if (hasPermissionsToWrite())
        {
            // request permissions
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_PERMISSION_STORAGE_SAVE);
        }
        else
        {
            // TODO: save the image if image is displayed




        }
    }

    private boolean hasPermissionsToWrite()
    {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onClick(View v)
    {
        if (v == buttonOpenImage)
        {
            // TODO: launch an intent to get an image from camera app
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            try
            {
              startActivityForResult(takePictureIntent, REQUEST_VIDEO_CAPTURE);
            }
            catch (ActivityNotFoundException e) {
                // display error state to the user
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case REQUEST_PERMISSION_STORAGE_DELETE:
            {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    // show dialog if image file exists
                    // TODO: show dialog if image file exists
                }
                else
                {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    // TODO: show message
                }
            }
            case REQUEST_PERMISSION_STORAGE_SAVE:
            {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    // save the image file
                    // TODO: save the image
                }
                else
                {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    // TODO: show message
                }
            }
        }


    }

    @Override
    /**
     * Metode que el que fa es guardar la imatge devant de la app
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK)
        {
            Bundle extra = data.getExtras();
            Bitmap bitmap = (Bitmap) extra.get("data");
            imageView.setImageBitmap(bitmap);
            //tvMessage.setText(""); // per borrar el texte de devant
            tvMessage.setVisibility(View.GONE);
        }
    }
}