package edu.uoc.android.restservice.ui.adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.widget.TintableCheckedTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.uoc.android.restservice.R;
import edu.uoc.android.restservice.rest.model.Follower;

public class FollowerAdapter extends RecyclerView.Adapter<FollowerAdapter.ViewHolder>{

    List<Follower> listFollowrs = new ArrayList<Follower>();

    public FollowerAdapter(List<Follower> listFollowrs) {
        this.listFollowrs = listFollowrs;
    }

    @NonNull
    @Override
    public FollowerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_follower,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FollowerAdapter.ViewHolder holder, int position) {
        String name = listFollowrs.get(position).getName();
        String avatarLink = listFollowrs.get(position).getAvatarUrl();

        holder.setData(name, avatarLink);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView avatar;

        TextView avatarLink;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            name = itemView.findViewById(R.id.followerName);
            avatar = itemView.findViewById(R.id.followerAvatar);

            avatarLink = itemView.findViewById(R.id.infoAvatar);
        }

        public void setData(String name, String avatarUrl){
            this.name.setText(name);
            this.avatarLink.setText(avatarUrl);
        }


    }
}
