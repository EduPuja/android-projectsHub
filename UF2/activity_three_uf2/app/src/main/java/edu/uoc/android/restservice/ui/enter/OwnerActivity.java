package edu.uoc.android.restservice.ui.enter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import edu.uoc.android.restservice.R;
import edu.uoc.android.restservice.rest.adapter.GitHubAdapter;
import edu.uoc.android.restservice.rest.model.Follower;
import edu.uoc.android.restservice.rest.model.Owner;
import edu.uoc.android.restservice.ui.adapter.FollowerAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OwnerActivity extends AppCompatActivity {

    ImageView avatar;
    TextView repos,followers,titol;

    GitHubAdapter github;
    RecyclerView recyclerView;

    FollowerAdapter adapter;

    ArrayList<Follower> listFollowers;

    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);

        titol = findViewById(R.id.titol);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(2000);
        Handler handler = new Handler();

        listFollowers = new ArrayList<>();

        //!Find by id
        avatar = findViewById(R.id.avatar);
        repos= findViewById(R.id.repos);
        followers  = findViewById(R.id.followers);





        github = new GitHubAdapter();

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");


        //!fas la crida
        Call<Owner> call = github.getOwner(username);

        call.enqueue(new Callback<Owner>() {
            @Override
            public void onResponse(Call<Owner> call, Response<Owner> response) {
                if (response.isSuccessful()){
                    Owner owner = response.body();


                    String avatarLink = owner.getAvatarUrl();
                    //String name = owner.getName();
                    int numRepos = owner.getPublicRepos();
                    int follows = owner.getFollowing();

                    Picasso.get().load(avatarLink).into(avatar);
                    followers.setText("Followers: " +follows);
                    repos.setText("Repositoris: "+numRepos);




                }
            }

            @Override
            public void onFailure(Call<Owner> call, Throwable t) {
                Toast.makeText(OwnerActivity.this, "Error en la llamada: " + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        //!Afegint un follower
        Call<List<Follower>> callFollower = github.getFollwers(username);

        callFollower.enqueue(new Callback<List<Follower>>() {

            @Override
            public void onResponse(Call<List<Follower>> call, Response<List<Follower>> response) {

                if (response.isSuccessful()) {
                    List<Follower>  listAux = response.body();
                    for (Follower follower : listAux) {
                        listFollowers.add(follower);
                        initRecylcerView(); // initialize recicler
                    }
                }

            }

            @Override
            public void onFailure(Call<List<Follower>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error al pillar un follower :/", Toast.LENGTH_SHORT).show();
            }
        });



        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                avatar.setVisibility(View.VISIBLE);
                repos.setVisibility(View.VISIBLE);
                followers.setVisibility(View.VISIBLE);
                titol.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.VISIBLE);
                // amagar el pogres bar
                progressBar.setVisibility(View.INVISIBLE);



            }
        },2000);





    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.back:

                Intent intent = new Intent(this, EnterUserActivity.class);
                startActivity(intent);
                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }


    }


    // metode per inicialitzar el recycler view
    private void initRecylcerView()
    {

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FollowerAdapter(listFollowers);
        recyclerView.setAdapter(adapter);
    }

}

