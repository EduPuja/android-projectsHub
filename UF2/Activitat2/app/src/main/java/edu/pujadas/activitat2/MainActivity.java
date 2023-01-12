package edu.pujadas.activitat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity
{

    //imatges
    ImageView man;
    ImageView interficia;
    ImageView reciciclar;
    ImageView restaurant;
    ImageView tienda;
    ImageView viatjar;

    //text views
    TextView titol;
    TextView any;
    TextView descripcio;

    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // imatge view find by id
        man = findViewById(R.id.man);
        interficia = findViewById(R.id.interficia);
        reciciclar = findViewById(R.id.reciclar);
        restaurant = findViewById(R.id.restaurant);
        tienda = findViewById(R.id.tienda);
        viatjar= findViewById(R.id.viatgar);

        // text views
        titol = findViewById(R.id.titol);
        any = findViewById(R.id.any);
        descripcio = findViewById(R.id.descripcio);

        //video

        video = findViewById(R.id.video);

    }

    public void onImgClick(View vista)
    {
       /* Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();*/
    }
}