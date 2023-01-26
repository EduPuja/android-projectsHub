package edu.pujadas.activitat4_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PerformanceHintManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import edu.pujadas.activitat4_final.Models.Persona;

public class UserActivity extends AppCompatActivity
{

    private ArrayList<Persona> listPersona = new ArrayList<Persona>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        //preferenices
        SharedPreferences sharedPreferences = getSharedPreferences("USER_INFO",MODE_PRIVATE);
        Gson gson = new Gson();
        String info = sharedPreferences.getString("listPersona","");

        Type type = new TypeToken<ArrayList<Persona>>() {}.getType();
        listPersona = gson.fromJson(info,type);
        // per mostrar el ultim  persona registrada
        int ultim = listPersona.size()-1;
        setTitle("Hello " + listPersona.get(ultim).getEmail());

    }
}