package edu.pujadas.eduard_pujadas_act9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import edu.pujadas.eduard_pujadas_act9.Fragments.FragmentImage;
import edu.pujadas.eduard_pujadas_act9.Models.Producte;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    //arraylist productes
    ArrayList<Producte> listProducte;
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
        //construeixo el arraylist
        listProducte = new ArrayList<>();
        // build recicleview





    }

    /**
     * Metode que utliza el boto de save
     * @param vista
     */
    public void onSaveButon(View vista)
    {


        // variables que son recollides per el edit text
        String infoMarca = marcaProducte.getText().toString();
        String infoModel = modelProducte.getText().toString();
        // el guardo amb un string
        String quant = spinner.getSelectedItem().toString();
        String rutaImatge = "res/drawable/coding.png";

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


            Producte producte = new Producte();

            producte.setMarcaProducte(infoMarca);
            producte.setModelProducte(infoModel);
            producte.setQuantitat(quant);
            producte.setImageProducte(rutaImatge);

            listProducte.add(producte);

            // preferencias
            SharedPreferences sharedPreferences = getSharedPreferences("PRODUCTE_DATA",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit(); // editor
            Gson gson= new Gson();

            String jsonProducte =gson.toJson(listProducte);
            editor.putString("listProductes",jsonProducte);
            editor.apply(); // necessari per poder guardar
            // paso les dades en el sharedpreferences
            /*editor.putString("marca",producte.getMarcaProducte());
            editor.putString("model",producte.getModelProducte());
            editor.putString("quant",spinner.getSelectedItem().toString());
            editor.putString("img",producte.getRutaImatge());*/



            //canviar de pantalla
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }

    }

    /**
     * metode que crea la imatge
     * @param vista
     */
    public void onImgButton(View vista)
    {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        try
        {
            startActivityForResult(takePictureIntent, REQUEST_VIDEO_CAPTURE);

            // CREACIO DE UN FRAGEMENT

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.setReorderingAllowed(true);
            fragmentTransaction.replace(R.id.container_fragment, new FragmentImage()); // replace !!
            fragmentTransaction.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



        createToast("Image Producte");
    }


    /**
     * Metode necessari per el implements en principi no fa res
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        //res passa
    }

    /**
     * Metode nothing selected
     * @param parent
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
        // noting happens
    }

    /**
     * Metode per crear un tosast
     * @param msg
     */
    public void createToast(String msg)
    {

        Context context = getApplicationContext();

        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, msg, duration);
        toast.show();
    }
}