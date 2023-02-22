package edu.pujadas.pujafoot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import edu.pujadas.pujafoot.Objects.Product;
import edu.pujadas.pujafoot.Objects.ProductAdapter;

public class UserActivity extends AppCompatActivity
{

    RecyclerView productesRView;
    // adapter
    ProductAdapter productAdapter;

    //layout manager
    LinearLayoutManager layoutManager;

    public static ArrayList<Product> listProducte = new ArrayList<Product>();
    //todo poner un recyclerView amb adapter i layoutManager ... and per ultim un arraylist que pugui insertar dades al recyclerView

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        setTitle("Llistat de Prodcutes");

        if(listProducte.isEmpty()) initData();
        //reciclerView
        initRecylcerView();
    }

    /**
     * Metode que es utilizat en el onCreate utilzia el recyclerview
     * i posa tot el necessari per poder-lo utilitzar
     */
    private void initRecylcerView()
    {
        //recicleview
        productesRView = findViewById(R.id.productRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        productesRView.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(listProducte);
        productesRView.setAdapter(productAdapter);

    }

    private void initData()
    {
        Product product = new Product(1,"Test",1);
        Product product2 = new Product(2,"Test 2",1);
        Product product3 = new Product(3,"Test 3",1);

        listProducte.add(product);
        listProducte.add(product2);
        listProducte.add(product3);

    }


    /**
     * Metode que el que fa es afegir un menu
     * @param menu menu
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_llistat, menu);
        return true;

    }

    /**
     * Metode item seleccionat del menu
     * @param item menu item
     * @return si es true
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        // Handle item selection
        switch (item.getItemId())
        {
            case R.id.add:
                Intent intent = new Intent(this, AddProductActivity.class);
                startActivity(intent);
                return true;
            case R.id.clear:
                listProducte.clear();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}