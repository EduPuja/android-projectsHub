package edu.pujadas.pujafoot;

import androidx.appcompat.app.AppCompatActivity;
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

    public static ArrayList<Product> listProducte = new ArrayList<Product>();
    //todo poner un recyclerView amb adapter i layoutManager ... and per ultim un arraylist que pugui insertar dades al recyclerView

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        setTitle("Llistat de Prodcutes");
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_llistat, menu);
        return true;

    }
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