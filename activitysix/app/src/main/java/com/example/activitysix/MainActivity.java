package com.example.activitysix;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.cert.CRLException;

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

    private Toast toastCorrect;
    // ruta img
    String rutaImg;
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
        // Inflem el menú. Aquesta acció afegeix els items a la barra de acció
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == R.id.action_delete)
        {
            // execusio del meteode onDeleteMenuTap()
            onDeleteMenuTap();
            return true;
        }
        else if (item.getItemId() == R.id.action_save)
        {
            // Executem el mètode onSaveMenuTap()
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
            //

          createDialog("Vols eliminar la imatge?","Delete Image");
        }
    }

    private void onSaveMenuTap()
    {
        // check permissions
        if (!hasPermissionsToWrite())
        {
            // request permissions
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_PERMISSION_STORAGE_SAVE);
        }
        else
        {
                createDialog("Vols guardar la Img","Save Img?");

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
            catch (ActivityNotFoundException e)
            {
                // display error state to the user
                e.printStackTrace();
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
                    createToast("Pots ELIMINAR");
                }
                else
                {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    // TODO: show message
                    createToast("No tenis Permisos");
                }
            }
            case REQUEST_PERMISSION_STORAGE_SAVE:
            {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    // save the image file
                    // TODO: save the image
                   createToast("Pots guardar!!");
                }
                else
                {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    // TODO: show message
                    createToast("CACA");
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
        //imageView.setImageBitmap(BitmapFactory.decodeFile(rutaImg));
        if(requestCode == 1 && resultCode == RESULT_OK)
        {
            Bundle extra = data.getExtras();
            Bitmap bitmap = (Bitmap) extra.get("data");
            imageView.setImageBitmap(bitmap);
            //tvMessage.setText(""); // per borrar el texte de devant
            tvMessage.setVisibility(View.GONE);
        }
    }



    /**
     * Metode per guradar la imatge
     */
    private void saveImageToExternalStorage()
    {

        File directori = new File(getExternalCacheDir(),"ActivitySix");
        if(!directori.exists())
        {
            directori.mkdir();
        }

        BitmapDrawable draw = (BitmapDrawable)  imageView.getDrawable();
        Bitmap  bitmap = draw.getBitmap();

        File fitxer = new File(directori,"jpg");

        try
        {
           FileOutputStream outputStream = new FileOutputStream(fitxer);
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
            createToast("Imatge guardada !");
            outputStream.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }




    }








    /**
     * Method that makes a toast / alert whatever you want a call it
     * @param texte
     */
    protected void createToast(String texte)
    {
        Context context = getApplicationContext();        //take the context app need for doing a toast
        int duration = Toast.LENGTH_SHORT;                 // duaration of a toast
        toastCorrect=Toast.makeText(context,texte,duration);    // crido el tosat i creo un text
        toastCorrect.show();                                    // showing the toast

    }

    /**
     * metode per crear un dialeg
     * @param msg
     * @param title
     */
    protected void createDialog(String msg,String title)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(msg);
        builder.setTitle(title);

        builder.setPositiveButton(R.string.action_yes, new DialogInterface.OnClickListener()
        {

            public void onClick(DialogInterface dialog, int id)
            {
                // save
                //createToast("Imatge guardada");
            }
        });
        builder.setNegativeButton(R.string.action_no, new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                // canecelar
               // createToast("Imatge no guardada");
            }
        });



        AlertDialog dialog = builder.create();
        dialog.show();
    }






}