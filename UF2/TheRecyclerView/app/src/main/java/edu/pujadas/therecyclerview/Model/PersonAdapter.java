package edu.pujadas.therecyclerview.Model;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import edu.pujadas.therecyclerview.R;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>
{
    List<Persona> listPersones = new ArrayList<Persona>();

    public PersonAdapter(List<Persona> listPersones)
    {
        this.listPersones = listPersones;
    }

    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item,parent,false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position)
    {
        Bitmap avatar = listPersones.get(position).getAvatar();
        String nom = listPersones.get(position).getNom();
        String congom = listPersones.get(position).getCognom();

        holder.setData(avatar,nom,congom);
    }

    @Override
    public int getItemCount()
    {
        return this.listPersones.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView avatar;
        TextView nom;
        TextView cognom;

        public ViewHolder(View vista)
        {
            super(vista);
            avatar = vista.findViewById(R.id.avatar);
            nom = vista.findViewById(R.id.nom);
            cognom = vista.findViewById(R.id.cognom);

        }

        public void setData(Bitmap avatar, String nom, String congom)
        {
            this.avatar.setImageBitmap(avatar);
            this.nom.setText(nom);
            this.cognom.setText(congom);
        }
    }
}
