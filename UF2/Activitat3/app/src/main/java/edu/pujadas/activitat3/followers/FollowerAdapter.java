package edu.pujadas.activitat3.followers;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FollowerAdapter extends RecyclerView.Adapter<FollowerAdapter.ViewHolder>
{
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {

    }

    @Override
    public int getItemCount()
    {
        return 0;
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        //private final TextView textView;

        public ViewHolder(View view)
        {
            super(view);
            // Define click listener for the ViewHolder's View

            //textView =  view.findViewById(R.id.textView);
        }

        /*public TextView getTextView() {
            return textView;
        }*/
    }

}
