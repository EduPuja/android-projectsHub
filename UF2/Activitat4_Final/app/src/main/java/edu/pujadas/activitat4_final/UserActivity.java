package edu.pujadas.activitat4_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.PerformanceHintManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import edu.pujadas.activitat4_final.Models.Home;
import edu.pujadas.activitat4_final.Models.HomeAdapter;
import edu.pujadas.activitat4_final.Models.Persona;

public class UserActivity extends AppCompatActivity
{
    // arraylist de persones per poder afegir el titol
     private ArrayList<Persona> listPersona = new ArrayList<Persona>();
     //arryalist necessari per poder afegir les cases
     private ArrayList<Home> listHomes = new ArrayList<Home>();

     RecyclerView recyclerView ;
     HomeAdapter homeAdapter;
    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        // metode shared prefenrece
        preferencies();

        // metode que inicia dades falses al arraylist de cases
        initData();

        // metode que crea el reciclerview
        initRecylcerView();
    }

    /**
     * Metode que utliza el shared preferences
     */
    private void preferencies()
    {
        //preferenices
        SharedPreferences sharedPreferences = getSharedPreferences("USER_INFO",MODE_PRIVATE);
        Gson gson = new Gson();
        String info = sharedPreferences.getString("listPersona","");

        Type type = new TypeToken<ArrayList<Persona>>() {}.getType();
        listPersona = gson.fromJson(info,type);
        // per mostrar el ultim  persona registrada
        int ultim = listPersona.size()-1;
        setTitle("Hello " + listPersona.get(ultim).getEmail());
    }

    /**
     * Metode que afegiex dades en el recicleView
     */
    private void initData()
    {
        //creant un objecte casa
        Home homePals= new Home("Pals",BitmapFactory.decodeResource(getBaseContext().getResources(),R.drawable.casaa));
        Home homePalamos= new Home("Palamos",BitmapFactory.decodeResource(getBaseContext().getResources(),R.drawable.casab));
        Home homeCasaC= new Home("Vallobrega",BitmapFactory.decodeResource(getBaseContext().getResources(),R.drawable.casac));
        Home homeCasaD= new Home("Mataró",BitmapFactory.decodeResource(getBaseContext().getResources(),R.drawable.casad));

        listHomes.add(homePals);
        listHomes.add(homePalamos);
        listHomes.add(homeCasaC);
        listHomes.add(homeCasaD);
    }

    private void initRecylcerView()
    {
        //recicleview
        recyclerView = findViewById(R.id.recicleView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        homeAdapter = new HomeAdapter(listHomes);
        recyclerView.setAdapter(homeAdapter);
        homeAdapter.notifyDataSetChanged();
    }
}