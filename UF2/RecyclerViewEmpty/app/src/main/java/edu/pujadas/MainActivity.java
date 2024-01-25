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

        listHomes = new ArrayList<>();
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


        listHomes.add(new Home("Pals", BitmapFactory.decodeResource(getBaseContext().getResources(),R.drawable.casaa)));
        listHomes.add(new Home("Palamos",BitmapFactory.decodeResource(getBaseContext().getResources(),R.drawable.casab)));
        listHomes.add(new Home("Vallobrega",BitmapFactory.decodeResource(getBaseContext().getResources(),R.drawable.casac)));
        listHomes.add(new Home("Mataró",BitmapFactory.decodeResource(getBaseContext().getResources(),R.drawable.casad)));
        listHomes.add(new Home("AAA",BitmapFactory.decodeResource(getBaseContext().getResources(),R.drawable.casad)));
        listHomes.add(new Home("BBB",BitmapFactory.decodeResource(getBaseContext().getResources(),R.drawable.casab)));
        listHomes.add(new Home("CCC",BitmapFactory.decodeResource(getBaseContext().getResources(),R.drawable.casad)));
        listHomes.add(new Home("DDD",BitmapFactory.decodeResource(getBaseContext().getResources(),R.drawable.casad)));

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