package edu.pujadas.eduard_pujadas_act9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import edu.pujadas.eduard_pujadas_act9.Fragments.FragmentImage;
import edu.pujadas.eduard_pujadas_act9.Models.Producte;

public class MainActivity extends AppCompatActivity
{

    // permisos camera
    private final int REQUEST_PERMISSION_STORAGE_SAVE = 101;
    private final int REQUEST_PERMISSION_STORAGE_DELETE = 102;
    private static final int REQUEST_VIDEO_CAPTURE = 1;

    //edit text
    private EditText marcaProducte;
    private EditText modelProducte;
    //spinner
    private Spinner spinner;
    // butons
    private Button saveButon;
    private Button imgButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Formulari Producte");
        marcaProducte=findViewById(R.id.marca_product);
        modelProducte = findViewById(R.id.model_product);
        //spinner
        spinner  = findViewById(R.id.spinner);
        // adaptador
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.quantitat_productes, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



    }

    /**
     * Metode que utliza el boto de save
     * @param vista
     */
    public void onSaveButon(View vista)
    {


        String infoMarca = marcaProducte.getText().toString();
        String infoModel = modelProducte.getText().toString();
        String infoSpin =spinner.toString(); // no se si funciona


        if(infoMarca.isEmpty())
        {
            marcaProducte.setError("Aquest camp no pot esta buit");
        }
        else if(infoModel.isEmpty())
        {
            modelProducte.setError("Aquest camp no pot esta buit");
        }
        else
        {

            Intent intent = new Intent(this,SecondActivity.class);
            Producte producte = new Producte();
            producte.setAllProducte(infoMarca,infoModel,Integer.parseInt(infoSpin),null);   //todo falta imatge
            intent.putExtra("producte",(Parcelable) producte);  // convertiexo el objecte producte amb parcelable per poderlo passar

            // quantitat
            // image ?
            startActivity(intent);
        }

    }

    /**
     * Metode que uilizara el boto de obrir la camara
     * @param vista
     */
    public void onImgButon(View vista)
    {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try
        {
            startActivityForResult(takePictureIntent, REQUEST_VIDEO_CAPTURE);

            // posar el fragemnt imatge
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setReorderingAllowed(true);
            fragmentTransaction.replace(R.id.container_fragment, new FragmentImage()); // replace !!
            fragmentTransaction.commit();
        }
        catch (ActivityNotFoundException e)
        {
            // display error state to the user
            e.printStackTrace();
        }
        //todo agafa la foto i posarla en un iamge view per despres carregar un fragment


    }


}