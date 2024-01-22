package edu.uoc.android.restservice.ui.enter;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import edu.uoc.android.restservice.R;
import edu.uoc.android.restservice.rest.model.Owner;

public class EnterUserActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUser;
    private Button btnFollowers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_user);
        initViews();
    }

    private void initViews() {
        etUser = findViewById(R.id.enter_user_edit_text);
        btnFollowers = findViewById(R.id.enter_user_button);
        btnFollowers.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnFollowers) {
            String username = etUser.getText().toString();
            if (username.isEmpty())
            {
                etUser.setError("Please enter a username");
            }else
            {
                Intent intent = new Intent(v.getContext(), OwnerActivity.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }


        }
    }
}
