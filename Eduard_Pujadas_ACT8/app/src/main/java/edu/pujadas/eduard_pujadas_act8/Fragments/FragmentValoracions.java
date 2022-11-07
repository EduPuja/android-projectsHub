package edu.pujadas.eduard_pujadas_act8.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;

import edu.pujadas.eduard_pujadas_act8.Models.Valoracions;
import edu.pujadas.eduard_pujadas_act8.R;
import edu.pujadas.eduard_pujadas_act8.adapters.ValorationsAdapter;

public class FragmentValoracions extends Fragment
{
    private final ArrayList<Valoracions> listValoracions = new ArrayList<Valoracions>();
    private ValorationsAdapter valorationsAdapter;
    private ListView listView;

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
        View vista = layoutInflater.inflate(R.layout.fragment_valo,container,false);

        fakeData();
        return vista;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);


    }
    private void fakeData()
    {
        Valoracions valoOne =new Valoracions("Eduard Pujadas","esta guai","20");
        Valoracions valoTwo =new Valoracions("Daniel Escobar","esta Be","15");
        Valoracions valoTree =new Valoracions("Alumne prova","que xulo!","50");


        // afegixio totes les valoracions a dins del arraylist
        listValoracions.add(valoOne);
        listValoracions.add(valoTwo);
        listValoracions.add(valoTree);

        listView.setAdapter(valorationsAdapter);


    }
}
