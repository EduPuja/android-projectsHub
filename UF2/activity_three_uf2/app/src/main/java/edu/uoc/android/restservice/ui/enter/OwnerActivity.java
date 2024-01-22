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

import edu.uoc.android.restservice.R;

public class OwnerActivity extends AppCompatActivity {

    ImageView avatar;
    TextView repos,followers;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);


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