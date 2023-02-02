package edu.pujadas.activitat3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import edu.pujadas.activitat3.followers.Follower;
import edu.pujadas.activitat3.followers.FollowerAdapter;

public class FollowersActivity extends AppCompatActivity
{


    public static ArrayList<Follower> listFollowers = new ArrayList<Follower>();


    RecyclerView followers_recyclerView;
    FollowerAdapter followerAdapter;
    LinearLayoutManager layoutManager;

    TextView count_repos;
    TextView num_followers;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers);
        count_repos = findViewById(R.id.count_repos);
        num_followers =findViewById(R.id.num_followers);
        if(listFollowers.isEmpty()) initData();

        String nom = getIntent().getExtras().getString("nomUsuari");

        count_repos.setText(nom);

        num_followers.setText(listFollowers.size() +" Followers");


        // metode per iniciar el recicler view
        initRecylcerView();

    }



    /**
     * Metode per iniciar amb dades falçes
     */
    public void initData()
    {

        //creant un objecte casa
        Follower follower= new Follower("Joan", BitmapFactory.decodeResource(getBaseContext().getResources(),R.drawable.man));
        Follower follower2= new Follower("Edu", BitmapFactory.decodeResource(getBaseContext().getResources(),R.drawable.man));
        Follower follower3= new Follower("Dani", BitmapFactory.decodeResource(getBaseContext().getResources(),R.drawable.man));
        Follower follower4= new Follower("LLuis", BitmapFactory.decodeResource(getBaseContext().getResources(),R.drawable.man));



        listFollowers.add(follower);
        listFollowers.add(follower2);
        listFollowers.add(follower3);
        listFollowers.add(follower4);
    }

    /**
     * Metode que es utilizat en el onCreate utilzia el recyclerview
     * i posa tot el necessari per poder-lo utilitzar
     */
    private void initRecylcerView()
    {
        //recicleview
        followers_recyclerView = findViewById(R.id.followers_recyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        followers_recyclerView.setLayoutManager(layoutManager);
        followerAdapter = new FollowerAdapter(listFollowers);
        followers_recyclerView.setAdapter(followerAdapter);
        //homeAdapter.notifyDataSetChanged();
    }

}