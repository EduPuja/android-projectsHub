package com.example.activityseven.adapater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.activityseven.R;

import com.example.activityseven.database.model.Student;
import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter<Student>
{

    private final Context context;
    private final ArrayList<Student> students;

    public StudentAdapter(Context context, ArrayList<Student> students)
    {
        super(context, R.layout.studient_list_item);
        this.context = context;
        this.students = students;
    }

    public int getCount()
    {
        return students.size();
    }

    public Student getItem(int position)
    {
        return students.get(position);
    }

    public long getStudentId(int position)
    {
        return students.get(position).getId();
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = null;
        final ViewHolder viewHolder;

        if (convertView == null || convertView.getTag() == null)
        {
            viewHolder =  new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.studient_list_item, parent, false);
            viewHolder.studentName = view.findViewById(R.id.info_alumne);

            viewHolder.button = view.findViewById(R.id.buto_alumne);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.studentName.setText(students.get(position).getName());

        return view;
    }

    static class ViewHolder
    {
        TextView studentName;
        Button button;


    }
}