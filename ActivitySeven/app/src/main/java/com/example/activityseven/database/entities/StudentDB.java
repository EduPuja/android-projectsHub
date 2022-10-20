package com.example.activityseven.database.entities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.example.activityseven.database.helper.StudentElementHelper;
import com.example.activityseven.database.model.Student;

import java.util.ArrayList;

public class StudentDB
{

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    private final StudentElementHelper dbHelper;

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public StudentDB(Context context)
    {
        // Create new helper
        dbHelper = new StudentElementHelper(context);
    }

    /* Inner class that defines the table contents */
    public static abstract class StudentElementEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_TITLE = "title";

        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT" + COMMA_SEP +
                COLUMN_NAME_TITLE + TEXT_TYPE + " )";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }


    /**
     * Method to create new element in the database
     *
     */
    public void insertElement(String studentName)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // New values
        ContentValues values = new ContentValues();
        values.put(StudentElementEntry.COLUMN_NAME_TITLE, studentName);
        // Insert the new row to the database
        db.insert(StudentElementEntry.TABLE_NAME, null, values);
    }

    /**
     * Method to get all the shopping elements of the database
     *
     * @return ShoppingItem array
     */
    public ArrayList<Student> getAllItems()
    {
        ArrayList<Student> shoppingItems = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        // Do the query to the database
        Cursor cursor = db.query (StudentElementEntry.TABLE_NAME, null, null,
                null, null, null, null);
        // Get all the rows of database
        while(cursor.moveToNext())
        {
            // Get item id
            long itemId = cursor.getLong(cursor.getColumnIndexOrThrow(StudentElementEntry._ID));
            // Get item name
            String itemName = cursor.getString(cursor.getColumnIndexOrThrow(
                    StudentElementEntry.COLUMN_NAME_TITLE));
            // Add item id and name to the shopping list
            shoppingItems.add(new Student(itemId, itemName));
        }
        return shoppingItems;
    }

    /**
     * Method to clear all the elements
     */
    public void clearAllItems()
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // Delete all data of the database table
        db.delete(StudentElementEntry.TABLE_NAME,null,null);
    }

    /**
     * Method to update a database item
     *
     */
    public void updateItem(Student studentItem)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // New values
        ContentValues values = new ContentValues();
        values.put(StudentElementEntry.COLUMN_NAME_TITLE, studentItem.getName());
        // Get item id
        long id = studentItem.getId();
        // Update database
        db.update(StudentElementEntry.TABLE_NAME, values,"_id="+id,  null);
    }

    /**
     * Method to delete one item
     *
     */
    public void deleteItem(Student studentItem)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // Get item id
        long id = studentItem.getId();
        // Delete item
        db.delete(StudentElementEntry.TABLE_NAME,"_id="+id,null);
    }
}
