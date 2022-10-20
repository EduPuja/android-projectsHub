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
    private  final ArrayList<Student> listStudens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list_view);
        studentDB=new StudentDB(this);
        studentDB.clearAllItems(); // natejem tots els items
    }
}