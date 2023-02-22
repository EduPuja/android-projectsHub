package edu.pujadas.pujafoot.Objects;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.pujadas.pujafoot.R;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>
{
    List<Product> listProduct = new ArrayList<Product>();
    public ProductAdapter(List<Product> listProduct)
    {
        this.listProduct = listProduct;
    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item,parent,false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(ProductAdapter.ViewHolder holder, int position)
    {
        int id = listProduct.get(position).getId();
        String nom = listProduct.get(position).getName();
        int quantitat = listProduct.get(position).getQuantity();

        holder.setData(id,nom,quantitat);
    }

    @Override
    public int getItemCount()
    {
        return listProduct.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView idTextView;
        TextView nomView;
        TextView cognomView;

        public ViewHolder(@NonNull View vista)
        {
            super(vista);
            idTextView = vista.findViewById(R.id.idProducte);
            nomView = vista.findViewById(R.id.nomProducte);
            cognomView = vista.findViewById(R.id.quantitatProducte);

        }


        public void setData(int id, String nom, int quantitat)
        {
            this.idTextView.setText(id);
            this.idTextView.setText(nom);
            this.idTextView.setText(quantitat);
        }
    }
}
