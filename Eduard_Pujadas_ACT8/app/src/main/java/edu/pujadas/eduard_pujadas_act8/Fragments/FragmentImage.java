package edu.pujadas.eduard_pujadas_act8.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import java.nio.Buffer;

import edu.pujadas.eduard_pujadas_act8.R;


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
