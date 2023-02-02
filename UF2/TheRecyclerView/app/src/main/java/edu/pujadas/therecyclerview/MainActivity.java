package edu.pujadas.therecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import java.util.ArrayList;

import edu.pujadas.therecyclerview.Model.PersonAdapter;
import edu.pujadas.therecyclerview.Model.Persona;

public class MainActivity extends AppCompatActivity
{

    RecyclerView recyclerView;
    PersonAdapter personAdapter;
    LinearLayoutManager layoutManager ;

    public static ArrayList<Persona> listPersones = new ArrayList<Persona>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(listPersones.isEmpty())
        {
            initData();
        }


        initRecylcerView();

    }
    protected void initData()
    {
        Bitmap avatar = BitmapFactory.decodeResource(getBaseContext().getResources(),R.drawable.person);
        // afegint dades al arraylist
        listPersones.add(new Persona(avatar,"Eduard","Pujadas"));
        listPersones.add(new Persona(avatar,"Lluis","Bofill"));
        listPersones.add(new Persona(avatar,"Daniel","Escobar"));

    }

    /**
     * Metode que es utilizat en el onCreate utilzia el recyclerview
     * i posa tot el necessari per poder-lo utilitzar
     */
    private void initRecylcerView()
    {
        //recicleview
        recyclerView = findViewById(R.id.contact_recyclerView);
        //recyclerView.addOnItemTouchListener();
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        personAdapter = new PersonAdapter(listPersones);
        recyclerView.setAdapter(personAdapter);
        //homeAdapter.notifyDataSetChanged();
    }
}