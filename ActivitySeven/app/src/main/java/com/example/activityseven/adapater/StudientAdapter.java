package com.example.activityseven.adapater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.recyclerview.widget.RecyclerView;

import com.example.activityseven.R;
import com.example.activityseven.database.model.Student;

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

    /**
     * et retorna el id del estudiant
     * @param positio
     * @return
     */
     public long getStudientsId(int positio)
     {

         return listStudents.get(positio).getId();
     }


     /**
      * retornem una vista
      */
     @Override
    public View getView(int posicio, View convertView, ViewGroup parent)
     {
         View vista;
         final RecyclerView.ViewHolder viewHolder;
         if(convertView == null || convertView.getTag() == null)
         {
             // el cream
             viewHolder = new RecyclerView.ViewHolder()
          
             vista = LayoutInflater.from(context).inflate(R.layout.studient_list_item,parent,false);
             viewHolder.studientsName = vista.findViewById(R.id.info_studient);
             viewHolder.button = vista.findViewById(R.id.buto_alumne);
             // per ficar el muncipi aqui
             vista.setTag(viewHolder);


         }
         else // sino hi ha viewholder
         {

             viewHolder = (RecyclerView.ViewHolder) convertView.getTag();
             viewHolder.studentName.setText(listStudents.get(posicio).getName());

         }
     }
}
