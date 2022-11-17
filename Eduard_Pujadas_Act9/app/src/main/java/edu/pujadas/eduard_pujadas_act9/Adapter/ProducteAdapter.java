package edu.pujadas.eduard_pujadas_act9.Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import edu.pujadas.eduard_pujadas_act9.Models.Producte;
import edu.pujadas.eduard_pujadas_act9.R;

public class ProducteAdapter extends ArrayAdapter<Producte>
{
    private final Context context;
    private final ArrayList<Producte> listProductes;

    /**
     * Constucotr amb el contxes i el arraylist del objecte necessari
     * @param context
     * @param listProductes
     */
    public ProducteAdapter(Context context, ArrayList<Producte> listProductes)
    {
        super(context, R.layout.producte_list_item);
        this.context = context;
        this.listProductes= listProductes;
    }

    @Override
    public int getCount()
    {
        return listProductes.size();
    }

    @Override
    public Producte getItem(int position)
    {
        return listProductes.get(position);
    }

    /**
     * et retorna la posicio del objecte i fas un hasCode per que no hi ha id
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position)
    {
        return listProductes.get(position).hashCode();
    }
}
