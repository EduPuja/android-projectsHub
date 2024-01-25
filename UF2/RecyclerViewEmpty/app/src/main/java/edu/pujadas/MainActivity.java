package edu.pujadas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.BitmapFactory;
import android.os.Bundle;

import java.util.ArrayList;

import edu.pujadas.adapter.HomeAdapter;
import edu.pujadas.models.Home;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HomeAdapter homeAdapter;
    LinearLayoutManager layoutManager;

    ArrayList<Home> listHomes ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(listHomes.isEmpty())
        {
            initData();
        }
        initRecylcerView();
    }


    /**
     * Metode per iniciar les dades falces de cases
     */
    public void initData()
    {

        //creant un objecte casa
        Home homePals= new Home("Pals", BitmapFactory.decodeResource(getBaseContext().getResources(),R.drawable.casaa));
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
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        homeAdapter = new HomeAdapter(listHomes);
        recyclerView.setAdapter(homeAdapter);
        //homeAdapter.notifyDataSetChanged();
    }
}