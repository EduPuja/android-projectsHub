package edu.pujadas.eduard_pujadas_act9.Adapter;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

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


    /**
     * Metode important necesites una classe anomenada view holeder , esta a sota
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view;
        final ViewHolder viewHolder;

        if (convertView == null || convertView.getTag() == null)
        {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.producte_list_item, parent, false);
            viewHolder.marca = view.findViewById(R.id.marca);
            viewHolder.model = view.findViewById(R.id.model);
            viewHolder.quant = view.findViewById(R.id.quant);

            view.setTag(viewHolder);

        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
            view = convertView;
        }

        // shared preferences ??
        // Set text with the item name



        SharedPreferences preferences = context.getSharedPreferences("PRODUCTE_DATA", MODE_PRIVATE);
        String infoMarca = preferences.getString("marca","");
        String infoModel = preferences.getString("model","");
        String infoQuant = preferences.getString("quant","");
        String infoRuta = preferences.getString("img","");

        viewHolder.marca.setText(infoMarca);
        viewHolder.model.setText(infoModel);
        viewHolder.quant.setText(infoQuant);

        return view;
    }

    static class ViewHolder
    {
        TextView marca;
        TextView model;
        TextView quant;
    }
}
