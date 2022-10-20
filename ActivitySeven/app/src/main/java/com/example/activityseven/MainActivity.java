package com.example.activityseven;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
}