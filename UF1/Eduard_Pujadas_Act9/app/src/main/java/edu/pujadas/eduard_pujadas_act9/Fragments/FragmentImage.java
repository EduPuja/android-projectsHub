package edu.pujadas.eduard_pujadas_act9.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NonNls;

import java.util.ArrayList;

import edu.pujadas.eduard_pujadas_act9.Models.Producte;
import edu.pujadas.eduard_pujadas_act9.R;


public class FragmentImage extends Fragment
{

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
        View vista = layoutInflater.inflate(R.layout.fragment_img,container,false);

        return vista;
    }

  
}
