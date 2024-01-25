package edu.uoc.android.restservice.ui.enter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import edu.uoc.android.restservice.R;
import edu.uoc.android.restservice.rest.adapter.GitHubAdapter;
import edu.uoc.android.restservice.rest.model.Owner;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OwnerActivity extends AppCompatActivity {

    ImageView avatar;
    TextView repos,followers;

    GitHubAdapter github;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);

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
                    String name = owner.getName();
                    int num_repos =owner.getPublicRepos();

                    //? diu que es un intenger no int
                    int follower = owner.getFollowers();



                }
            }

            @Override
            public void onFailure(Call<Owner> call, Throwable t) {
                System.out.println("Error en la llamada: " + t.getMessage());

            }
        });





        //!Find by id
        avatar = findViewById(R.id.avatar);
        repos= findViewById(R.id.repos);
        followers  = findViewById(R.id.followers);

        recyclerView  = findViewById(R.id.recyclerView);

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