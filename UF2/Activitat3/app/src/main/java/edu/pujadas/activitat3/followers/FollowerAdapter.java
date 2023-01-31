package edu.pujadas.activitat3.followers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import edu.pujadas.activitat3.R;

public class FollowerAdapter extends RecyclerView.Adapter<FollowerAdapter.ViewHolder>
{
    //TODO REFACTOR THIS RECICLE VIEW
    private String[] localDataSet;

    public FollowerAdapter(String[] dataSet)
    {
        localDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.follower_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        //holder.item_avavtar;
    }

    @Override
    public int getItemCount()
    {
        return 0;
    }

    // VIEW HOLDER
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private final ImageView item_avatar;
        private final TextView item_follower_username;

        public ViewHolder(View view)
        {
            super(view);
            // Define click listener for the ViewHolder's View

            item_avatar =  view.findViewById(R.id.follower_avatar);
            item_follower_username = view.findViewById(R.id.count_repos);
        }

        /**
         * metode que et retrona el username
         * @return textview
         */
        public TextView getUsername()
        {
            return item_follower_username;
        }

        /**
         * metode que et retrona el avatar
         * @return avatar
         */
        public ImageView getAvatar()
        {
            return item_avatar;
        }
    }
}
