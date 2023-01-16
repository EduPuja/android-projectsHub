package edu.pujadas.activitat2;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

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


    //videoView
    VideoView videoView;

    // videos
    String videoIbai = "android.resource://" + getPackageName() + "/" + R.raw.ibai;
    String video1   = "android.resource://" + getPackageName() + "/" + R.raw.video1;

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

        videoView = findViewById(R.id.videoView);
        //video.setVideoPath("/raw/ibai.mkv");
        //video.start();


    }

    /**
     * Metode que li doncs a la foto del home
     * @param vista
     */

    public void onManClick(View vista)
    {


        // URI VIDEOS
        Uri uriIbai = Uri.parse(videoIbai);
        Uri uriVideo = Uri.parse(video1);

        if(R.id.man == man.getId())
        {
            titol.setText("Hombre solo");
            any.setText("2023");
            descripcio.setText("Hombre solo en la vida inventada per Eduard Pujadas");
            // uri video ibai
            videoView.setVideoURI(uriIbai);


            videoView.start();
        }

        else if(R.id.interficia == interficia.getId())
        {
            titol.setText("@string/interficia");
            any.setText("2023");
            descripcio.setText("Interficices que guai!");
            //uri video exemple
            videoView.setVideoURI(uriVideo);
            videoView.start();
        }

        else
        {
            titol.setText("Nothing");
            any.setText("nothing");
            descripcio.setText("nothing");
        }


    }

    /**
     * Interficia vista quant li donguis click a la foto
     * @param vista vista necessaria
     */
    public void onInterficieClcik(View vista)
    {

    }

    /**
     * Quant li doncs click a la imatge de reciclar
     * @param vista
     */
    public void onReciclarClick(View vista)
    {

    }

    /**
     * Quant li dons clcik a la imatge del resturants
     * @param vista View vista necessria per fer el onClick
     */
    public void onRestaurantClick(View vista)
    {

    }

    /**
     * Metode que utliza la foto de tenda
     * @param vista View
     */
    public void onTiendaClick(View vista)
    {

    }
}