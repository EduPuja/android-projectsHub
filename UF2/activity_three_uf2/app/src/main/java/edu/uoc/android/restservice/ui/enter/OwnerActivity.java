package edu.uoc.android.restservice.ui.enter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import edu.uoc.android.restservice.R;
import edu.uoc.android.restservice.rest.adapter.GitHubAdapter;
import edu.uoc.android.restservice.rest.model.Owner;
import edu.uoc.android.restservice.ui.adapter.FollowerAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OwnerActivity extends AppCompatActivity {

    ImageView avatar;
    TextView repos,followers;

    GitHubAdapter github;
    RecyclerView recyclerView;

    FollowerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);


        //!Find by id
        avatar = findViewById(R.id.avatar);
        repos= findViewById(R.id.repos);
        followers  = findViewById(R.id.followers);
        recyclerView  = findViewById(R.id.recyclerView);
        //todo linerarlayout and adpter
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
                    int follows = owner.getFollowers();

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



    }

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

}