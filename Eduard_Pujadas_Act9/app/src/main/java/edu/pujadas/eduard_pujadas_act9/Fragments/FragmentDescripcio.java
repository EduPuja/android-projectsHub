package edu.pujadas.eduard_pujadas_act9.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import edu.pujadas.eduard_pujadas_act9.Models.Producte;
import edu.pujadas.eduard_pujadas_act9.R;
import edu.pujadas.eduard_pujadas_act9.SecondActivity;

public class FragmentDescripcio extends Fragment
{

    private TextView marcaDescrip;
    private TextView modelDescrip;
    private TextView quantDescrip;
    private  ArrayList<Producte> listProducte = new ArrayList<Producte>();




    /**
     * Metode per crear un fragment TOTS SON IGUALS
     * @param layoutInflater
     * @param container
     * @param saveInstacneState
     * @return
     */
    @Override
    public View onCreateView (LayoutInflater layoutInflater, ViewGroup container, Bundle saveInstacneState)
    {
        super.onCreateView(layoutInflater,container,saveInstacneState);
        View vista = layoutInflater.inflate(R.layout.fragment_descrip,container,false);
        // agafo les prefences
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("PRODUCTE_DATA",Context.MODE_PRIVATE);


        // agafo el gson el creo
        Gson gson = new Gson();
        // creo un string amb tota la info del arraylsit
        String info = sharedPreferences.getString("listProductes","");
        //creo un type convertint
        Type type = new TypeToken<ArrayList<Producte>>() {}.getType();
        // afegiexo desde el json amb el arraylist i el type
        listProducte = gson.fromJson(info,type);

        //texviews que gracies a la vista els hi puc donar id per despres
         marcaDescrip = vista.findViewById(R.id.marcaDescrip);
         modelDescrip = vista.findViewById(R.id.modelDescrip);
         quantDescrip = vista.findViewById(R.id.quantDescrip);


        // poder afegir el text
         this.marcaDescrip.setText(listProducte.get(0).getMarcaProducte());
         this.modelDescrip.setText(listProducte.get(0).getModelProducte());
         this.quantDescrip.setText(listProducte.get(0).getQuantitat());

         //finalment retorno la vista on ho poso tot
        return vista;
    }




}
