package edu.pujadas.activitat2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
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
        // videos
        String videoIbai = "android.resource://" + getPackageName() + "/" + R.raw.ibai;
        String video1   = "android.resource://" + getPackageName() + "/" + R.raw.video1;

        // media
        MediaController mediaController = new MediaController(vista.getContext());

        // URI VIDEOS
        Uri uriIbai = Uri.parse(videoIbai);
        Uri uriVideo = Uri.parse(video1);

        if(R.id.man == man.getId())
        {
            titol.setText("Hombre solo");
            any.setText("2023");
            descripcio.setText("Hombre solo en la vida inventada per Eduard Pujadas");



            video.setMediaController(mediaController);
            mediaController.setAnchorView(video);


            // uri video ibai
            video.setVideoURI(uriIbai);


            video.start();
        }

        else if(R.id.interficia == interficia.getId())
        {
            titol.setText("Interficies");
            any.setText("2023");
            descripcio.setText("Interficices que guai!");


            video.setMediaController(mediaController);
            mediaController.setAnchorView(video);
            //uri video exemple
            video.setVideoURI(uriVideo);
            video.start();
        }

        else
        {
            titol.setText("Nothing");
            any.setText("nothing");
            descripcio.setText("nothing");
        }











        /*
           VideoView video = findViewById(R.id.videoView);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.ibai;
        Uri uri = Uri.parse(videoPath);
        video.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        video.setMediaController(mediaController);
        mediaController.setAnchorView(video);



        video.start();
         */
    }
}