package edu.pujadas.activitat4_final.Models;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

import edu.pujadas.activitat4_final.R;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>
{
    private List<Home> listHomes = new ArrayList<Home>();

    public HomeAdapter(List<Home> listHomes)
    {
        this.listHomes=listHomes;
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {  // Create a new view, which defines the UI of the list item
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item,parent,false);


        return new ViewHolder(vista) ;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position)
    {
        // items necessaris per poder afegir els objectes
        String nomHome = listHomes.get(position).getName();
        Bitmap img = listHomes.get(position).getImg();

        holder.setData(nomHome,img);
    }

    @Override
    public int getItemCount()
    {
        return listHomes.size();
    }


    /**
     * Classe de viewHolder necessari per poder-lo fer amb reicle vie
     */
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView homeImg;
        TextView textHome;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            homeImg = itemView.findViewById(R.id.homeImg);
            textHome = itemView.findViewById(R.id.textHome);
        }

        /**
         * Metode que afegeix tots els caps del recicleview del objecte que tu tinguis
         * @param nomHome String nom casa
         * @param img imatge
         */
        public void setData(String nomHome, Bitmap img)
        {
            homeImg.setImageBitmap(img);
            textHome.setText(nomHome);
        }
    }
}
