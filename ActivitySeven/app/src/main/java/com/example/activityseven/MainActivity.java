package com.example.activityseven;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.activityseven.adapater.StudentAdapter;
import com.example.activityseven.database.entities.StudentDB;
import com.example.activityseven.database.model.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    private StudentDB studentDB;
    private StudentAdapter studentAdapter;
    private final ArrayList<Student> listStudients = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.students_list_view);

        // init database shopping list
        studentDB = new StudentDB(this);

        // start with an empty database
        studentDB.clearAllItems();

        // insert items
        insertStudents();

        listStudients.addAll(studentDB.getAllItems());

        studentAdapter = new StudentAdapter(this, listStudients);
        listView.setAdapter(studentAdapter);


    }

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

    private void onUpdateOne()
    {
    }

    private void onClearAll()
    {
    }

    private void onClearLast()
    {
    }

    private void onIncludeAll()
    {
    }

    private void onIncludeOne()
    {
    }

}