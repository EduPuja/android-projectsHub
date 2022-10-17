package com.example.activityseven.adapater;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.activityseven.R;
import com.example.activityseven.Student;

import java.util.ArrayList;

public class StudientAdapter extends ArrayAdapter<Student>
{
    private final Context context;
    private final ArrayList<Student> listStudents ;

     public StudientAdapter(Context context,ArrayList<Student> listStudents)
     {
         super(context, R.layout.studient_list_item);
         this.context= context;
         this.listStudents = listStudents;
     }

    /**
     * Metode que ense retorna tots els estudiants del arraylist
     * @return
     */
     public int getCount()
     {
         return listStudents.size();
     }

    /**
     * Metode que el que retorna es un estudiant del arraylist
     * @param posicio
     * @return
     */
     public Student getItem(int posicio)
     {
        return this.listStudents.get(posicio);
     }
}
