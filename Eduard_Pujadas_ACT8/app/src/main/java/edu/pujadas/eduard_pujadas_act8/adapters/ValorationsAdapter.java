package edu.pujadas.eduard_pujadas_act8.adapters;

import android.content.Context;

import java.util.ArrayList;

public class ValorationsAdapter
{
    private final Context context;
    private final ArrayList<Student> students;

    public ValorationsAdapter(Context context, ArrayList<Student> students)
    {
        super(context, R.layout.student_list_item);
        this.context = context;
        this.students = students;
    }


}
