package edu.pujadas.eduard_pujadas_act9.Fragments;

import android.content.Context;
import android.content.Intent;
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





        //texviews que gracies a la vista els hi puc donar id per despres
        marcaDescrip = vista.findViewById(R.id.marcaDescrip);
        modelDescrip = vista.findViewById(R.id.modelDescrip);
        quantDescrip = vista.findViewById(R.id.quantDescrip);


        // agafo el gson el creo
        Gson gson = new Gson();
        // creo un string amb tota la info del arraylsit
        String info = sharedPreferences.getString("listProductes","");
        //creo un type convertint
        Type type = new TypeToken<ArrayList<Producte>>() {}.getType();
        // afegiexo desde el json amb el arraylist i el type
        listProducte = gson.fromJson(info,type);


        //inteens

        int mac = getActivity().getIntent().getIntExtra("product",1);
        int screen =  getActivity().getIntent().getIntExtra("product",2);
        int tv = getActivity().getIntent().getIntExtra("product",3);
        int keyboard = getActivity().getIntent().getIntExtra("product",4);

        if(mac ==1) // digueimn que aixo agafga la activitat3 el seu intent que li passo jo
        {

            // bucle per poder comprovar cada valor del arraylist que tincgui macs nomes i els imprimeixi en els
            //texviews per poder despres retoraro amb forma de fragment
            for (int i=0;i<listProducte.size(); i++)
            {

                if(listProducte.get(i).getMarcaProducte().equalsIgnoreCase("mac"))
                {
                    // poder afegir el text dels macs??
                    this.marcaDescrip.setText(listProducte.get(i).getMarcaProducte());
                    this.modelDescrip.setText(listProducte.get(i).getModelProducte());
                    this.quantDescrip.setText(listProducte.get(i).getQuantitat());
                }

            }


            return vista;
        }
        else if(screen == 2)
        {

            for (int i=0;i<listProducte.size(); i++)
            {

                if(listProducte.get(i).getMarcaProducte().equalsIgnoreCase("Screen") ||  listProducte.get(i).getMarcaProducte().equalsIgnoreCase("Pantalla"))
                {
                    // poder afegir el text dels macs??
                    this.marcaDescrip.setText(listProducte.get(i).getMarcaProducte());
                    this.modelDescrip.setText(listProducte.get(i).getModelProducte());
                    this.quantDescrip.setText(listProducte.get(i).getQuantitat());
                }

            }
        }
        else if (tv == 3)


         //finalment retorno la vista on ho poso tot
        return vista;
    }




}
