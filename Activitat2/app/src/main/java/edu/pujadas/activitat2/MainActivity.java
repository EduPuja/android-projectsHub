package edu.pujadas.activitat2;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
    {
    public static final String EXTRA_MESSAGE = "edu.pujadas.myfirstapp.hola";

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }

    /**
     * Metode per crear una nova pantalla
     *
     * @param vista
     */
    public void openEduardActivity(View vista)
    {
        Intent intent = new Intent(this, ActivityEduard.class);
        startActivity(intent);
    }

        /*
         * Metode que obra la activitat pujadas
         * @param vista
         */
    public void openPujadasActivity(View vista)
        {
        Intent intent = new Intent(this, PujadasActivity.class);
        startActivity(intent);
        }

        /**
         * metode que obra la activity farras i a més envia el missatge
         * @param view
         */
    public void sendMessage(View view)
        {
            Intent intent = new Intent(this, FarrasActivity.class);
            EditText editText = (EditText) findViewById(R.id.enviarMissatge);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
    }
