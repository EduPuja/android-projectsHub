package edu.uoc.android.restservice.ui.enter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import edu.uoc.android.restservice.R;

public class OwnerActivity extends AppCompatActivity {

    ImageView avatar;
    TextView repos,followers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);


        //!Find by id
        avatar = findViewById(R.id.avatar);
        repos= findViewById(R.id.repos);
        followers  = findViewById(R.id.followers);

    }
}