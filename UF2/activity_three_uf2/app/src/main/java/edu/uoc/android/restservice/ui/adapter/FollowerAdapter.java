package edu.uoc.android.restservice.ui.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.uoc.android.restservice.rest.model.Follower;

public class FollowerAdapter extends RecyclerView.Adapter<Follower>{

     List<Follower> listFollowers = new ArrayList<Follower>();

    public FollowerAdapter(List<Follower> listFollowers) {
        this.listFollowers = listFollowers;
    }

    @NonNull
    @Override
    public Follower onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //todo do de adapter
    }

    @Override
    public void onBindViewHolder(@NonNull Follower holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
