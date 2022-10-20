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

public class StudentAdapter extends ArrayAdapter<Student> {

    private final Context context;
    private final ArrayList<Student> students;

    public StudentAdapter(Context context, ArrayList<Student> students) {
        super(context, R.layout.student_list_item);
        this.context = context;
        this.students = students;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Student getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return students.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        final ViewHolder viewHolder;

        if (convertView == null || convertView.getTag() == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.student_list_item, parent, false);
            viewHolder.studentName = view.findViewById(R.id.studentName);
            viewHolder.button = view.findViewById(R.id.button);

            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            view = convertView;
        }

        // Set text with the item name
        viewHolder.studentName.setText(students.get(position).getName());
        return view;
    }

    static class ViewHolder {
        TextView studentName;
        Button button;
    }
}
