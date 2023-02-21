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
        int quant = listProduct.get(position).getQuantity();

        holder.setData(id,nom,quant);
    }

    @Override
    public int getItemCount()
    {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView id;
        private TextView nom;
        private TextView quant;

        public ViewHolder(@NonNull View vista)
        {
            super(vista);
            id = vista.findViewById(R.id.idItem);
            nom = vista.findViewById(R.id.nameItem);
            quant = vista.findViewById(R.id.quantItem);

        }


        public void setData(int id, String nom, int quant)
        {
            this.id.setText(id);
            this.nom.setText(nom);
            this.quant.setText(quant);
        }
    }
}
