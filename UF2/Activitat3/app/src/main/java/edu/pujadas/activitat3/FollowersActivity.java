package edu.pujadas.activitat3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import edu.pujadas.activitat3.followers.FollowerAdapter;

public class FollowersActivity extends AppCompatActivity
{

    RecyclerView followers_recyclerView;
    FollowerAdapter followerAdapter;
    LinearLayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers);
    }
}