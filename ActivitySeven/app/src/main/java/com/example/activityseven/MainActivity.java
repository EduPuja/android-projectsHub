package com.example.activityseven;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.activityseven.adapater.StudentAdapter;
import com.example.activityseven.database.entities.StudentDB;
import com.example.activityseven.database.model.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    private StudentDB studentDB;

    private final ArrayList<Student> listStudients = new ArrayList<>();
    private StudentAdapter studentAdapter;
    private  ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.students_list_view);

        // init database shopping list
        studentDB = new StudentDB(this);

        // start with an empty database
        studentDB.clearAllItems();

        // insert items
       // insertStudents();

       //listStudients.addAll(studentDB.getAllItems());

        //studentAdapter = new StudentAdapter(this, listStudients);
        //listView.setAdapter(studentAdapter);


    }

    /**
     * Funcio que crea 2 studiants
     */
    private void insertStudents()
    {
        studentDB.insertElement("Eduard Pujadas");
        studentDB.insertElement("Daniel Escobar");
    }

    /**
     * Funcio per cridar el menu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflem el menú. Aquesta acció afegeix els items a la barra de acció
        getMenuInflater().inflate(R.menu.menu_action, menu);
        return true;
    }
    @Override
    /**
     * Funcio que sutiliza en els items del menu que quant es selecionen utilzien
     * una funcio
     */
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == R.id.include_one)
        {
            // metode include one
            onIncludeOne();
            //studentDB.insertElement("Alumne");
            return true;
        }
        else if (item.getItemId() == R.id.include_all)
        {
            // include all
            onIncludeAll();

            return true;
        }
        else if(item.getItemId()== R.id.clear_last)
        {
            // clear last
            onClearLast();

            return true;
        }
        else if(item.getItemId()==R.id.clear_all)
        {
            // clear all
            onClearAll();
            return true;
        }
        else if(item.getItemId() == R.id.update_one)
        {
            // update one
            onUpdateOne();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * Metode que utliza el item del menu per afegir un estudant a la llista
     * inclou 1 nou alumne a la llista
     */
    private void onIncludeOne()
    {
        studentDB.insertElement("Alumne");
        listStudients.clear();
        //studentAdapter.notifyDataSetChanged();
        listStudients.addAll(studentDB.getAllItems());
        studentAdapter = new StudentAdapter(this, listStudients);
        listView.setAdapter(studentAdapter);

    }

    /**
     * Metode que el que fa es entrar 15 studnats
     *  inclou 15 nous alumnes a la llista
     */
    private void onIncludeAll()
    {

        for(int i =0;i<15;i++)
        {
            studentDB.insertElement("Alumne" +i);
        }
    }
    /**
     * Metode que esborra l'ultim alumne
     * esborra l’últim alumne de la llista
     */
    private void onClearLast()
    {

        studentDB.deleteItem(listStudients.get(listStudients.size()));
        listStudients.addAll(studentDB.getAllItems());
        studentAdapter = new StudentAdapter(this, listStudients);
        listView.setAdapter(studentAdapter);
        studentAdapter.notifyDataSetChanged();
    }

    /**
     * Metode que esborra tots els alumnes de la llista
     * esborra tots els alumnes de la llista
     */
    private void onClearAll()
    {
        studentDB.clearAllItems();
        listStudients.addAll(studentDB.getAllItems());
        studentAdapter = new StudentAdapter(this, listStudients);
        listView.setAdapter(studentAdapter);
        studentAdapter.notifyDataSetChanged();
    }




    /**
     * Funcio que utliza el item del menu
     * canvi el nom del primer alumnes de la llista
     */
    private void onUpdateOne()
    {
        studentDB.updateItem(listStudients.get(0));

        studentAdapter.notifyDataSetChanged();
        listStudients.addAll(studentDB.getAllItems());
        studentAdapter = new StudentAdapter(this, listStudients);
        listView.setAdapter(studentAdapter);
    }

    /**
     * Metode per el buto fitxa ALumne
     * et crea una activity amb la fitxa del alumne
     * @param vista  necessari per poder linkejar
     */
    public void onStudientProfileActivity(View vista)
    {
        Intent intent = new Intent(this,StudientProfileActivity.class);

        startActivity(intent);
    }






}