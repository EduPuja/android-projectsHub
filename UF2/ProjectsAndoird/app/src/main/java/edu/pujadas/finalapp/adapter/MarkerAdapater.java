package edu.pujadas.finalapp.adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.model.Marker;

import java.util.ArrayList;
import java.util.List;

import edu.pujadas.finalapp.InfoActivity;
import edu.pujadas.finalapp.R;

public class MarkerAdapater extends RecyclerView.Adapter<MarkerAdapater.ViewHolder> {

    List<Marker> listMarker = new ArrayList<Marker>();

    public MarkerAdapater(List<Marker> listMarker) {
        this.listMarker = listMarker;
    }

    @NonNull
    @Override
    public MarkerAdapater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_marker,parent,false);

        return new ViewHolder(vista) ;


    }

    @Override
    public void onBindViewHolder(@NonNull MarkerAdapater.ViewHolder holder, int position) {
        String title = listMarker.get(position).getTitle();

        holder.setData(title); // es podria posar mes

        //fent el onclick
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), InfoActivity.class);

                // pass the info to the intent
                intent.putExtra("titol",title);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMarker.size();
    }


    // Class View Holder
    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView logo; //!change this
        TextView titol; //!change this

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            logo = itemView.findViewById(R.id.logo);
            titol = itemView.findViewById(R.id.titolMarker);
        }

        // Set Data Custom Method
        public void setData(String nomHome){

            titol.setText(nomHome);
        }
}   }
