package edu.pujadas.activitat4_final.Models;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.pujadas.activitat4_final.R;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>
{
    private List<Home> listHomes = new ArrayList<Home>();

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item,parent,false);
        return RecyclerView.ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position)
    {
        String nomHome = listHomes.get(position).getName();
        Bitmap img = listHomes.get(position).getImg();
    }

    @Override
    public int getItemCount()
    {
        return 0;
    }
}
