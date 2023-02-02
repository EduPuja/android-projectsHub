package edu.pujadas.activitat3.followers;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.pujadas.activitat3.R;

public class FollowerAdapter extends RecyclerView.Adapter<FollowerAdapter.ViewHolder>
{
    
    private List<Follower> listFollowers = new ArrayList<Follower>();

    public FollowerAdapter(List<Follower> listOwners)
    {
        this.listFollowers = listOwners;
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
        String nomUser = listFollowers.get(position).getNameFollower();
        Bitmap avatar = listFollowers.get(position).getAvatarFollower();

        holder.setData(nomUser,avatar);
    }

    @Override
    public int getItemCount()
    {
        return listFollowers.size();
    }

    // VIEW HOLDER
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private final ImageView follower_avatar;
        private final TextView follower_username;

        public ViewHolder(View view)
        {
            super(view);
            // Define click listener for the ViewHolder's View

            follower_avatar =  view.findViewById(R.id.follower_avatar);
            follower_username = view.findViewById(R.id.follower_username);
        }

        public void setData(String nomFollower, Bitmap avatar)
        {
            follower_avatar.setImageBitmap(avatar);
            follower_username.setText(nomFollower);
        }

        /**
         * metode que et retrona el username
         * @return textview
         */
        public TextView getUsername()
        {
            return follower_username;
        }

        /**
         * metode que et retrona el avatar
         * @return avatar
         */
        public ImageView getAvatar()
        {
            return follower_avatar;
        }
    }
}
