package edu.pujadas.eduard_pujadas_act8.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import edu.pujadas.eduard_pujadas_act8.Models.Valoracions;
import edu.pujadas.eduard_pujadas_act8.R;

public class ValorationsAdapter extends ArrayAdapter<Valoracions>
{
    private final Context context;
    private  final ArrayList<Valoracions> listValoracions;

    public ValorationsAdapter(Context context, ArrayList<Valoracions> listValoracions)
    {
        super(context, R.layout.valo_list_item);
        this.context = context;
        this.listValoracions = listValoracions;
    }


}
