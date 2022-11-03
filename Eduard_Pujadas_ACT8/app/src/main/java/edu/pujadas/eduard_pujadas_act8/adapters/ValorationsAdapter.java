package edu.pujadas.eduard_pujadas_act8.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

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




    @Override
    public int getCount()
    {
        return listValoracions.size();
    }

    @Override
    public Valoracions getItem(int position)
    {
        return listValoracions.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return listValoracions.get(position).getPunts();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view;
        final ViewHolder viewHolder;

        if (convertView == null || convertView.getTag() == null)
        {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.valo_list_item, parent, false);


            // afago les id de la vista gracies al view holder esta a sota
            viewHolder.nomUser = view.findViewById(R.id.nomUser);
            viewHolder.descrip= view.findViewById(R.id.descrip);
            viewHolder.punts = view.findViewById(R.id.punts);

            view.setTag(viewHolder);

        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
            view = convertView;
        }

        // Set text with the item name
        viewHolder.nomUser.setText(listValoracions.get(position).getNomUser());
        viewHolder.descrip.setText(listValoracions.get(position).getDescrip());
        viewHolder.punts.setText(listValoracions.get(position).getPunts());
        return view;
    }

    static class ViewHolder
    {
        TextView nomUser;
        TextView descrip;
        TextView punts;

    }


}
