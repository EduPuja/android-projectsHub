package edu.pujadas.activitat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.net.URL;

public class MainActivity extends AppCompatActivity
{

    //imatges
    ImageView man;
    ImageView interficia;
    ImageView recicle;
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
        recicle = findViewById(R.id.recicle);
        restaurant = findViewById(R.id.restaurant);
        tienda = findViewById(R.id.tienda);
        viatjar= findViewById(R.id.viatgar);

        // text views
        titol = findViewById(R.id.titol);
        any = findViewById(R.id.any);
        descripcio = findViewById(R.id.descripcio);

        //video

        video = findViewById(R.id.video);
        //video.setVideoPath("/raw/ibai.mkv");
        //video.start();


    }

    public void onImgClick(View vista)
    {
        titol.setText("Hombre solo");
        any.setText("2023");
        descripcio.setText("Hombre solo en la vida inventada per Eduard Pujadas");
        // todo posar un video
        video.setVideoPath("raw/video1.mp4");
        video.start();


    }
}