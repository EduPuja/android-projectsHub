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
     * @param vista vista
     */
    public void onManClick(View vista)
    {
        // videos
        String videoIbai = "android.resource://" + getPackageName() + "/" + R.raw.ibai;


        // URI VIDEOS
        Uri uriIbai = Uri.parse(videoIbai);



        titol.setText("Hombre solo");
        any.setText("2023");
        descripcio.setText("Hombre solo en la vida inventada per Eduard Pujadas");
        // uri video ibai
        videoView.setVideoURI(uriIbai);

        videoView.start();




    }

    /**
     * Interficia vista quant li donguis click a la foto
     * @param vista vista necessaria
     */
    public void onInterficieClcik(View vista)
    {
        String video1   = "android.resource://" + getPackageName() + "/" + R.raw.video1;
        Uri uriVideo = Uri.parse(video1);


        titol.setText("Interficies!");
        any.setText("2023");
        descripcio.setText("Interficices que guai!");
        //uri video exemple
        videoView.setVideoURI(uriVideo);
        videoView.start();
    }

    /**
     * Quant li doncs click a la imatge de reciclar
     * @param vista View vista
     */
    public void onReciclarClick(View vista)
    {
        String reciclar   = "android.resource://" + getPackageName() + "/" + R.raw.reciclar;
        Uri uriRecilar = Uri.parse(reciclar);

        titol.setText("RECICLAR!");
        any.setText("2023");
        descripcio.setText("El reciclatge és molt importnat");
        videoView.setVideoURI(uriRecilar);
        videoView.start();
    }

    /**
     * Quant li dons clcik a la imatge del resturants
     * @param vista View vista necessria per fer el onClick
     */
    public void onRestaurantClick(View vista)
    {

        String restaurant   = "android.resource://" + getPackageName() + "/" + R.raw.restaurant;
        Uri uriRestaruant = Uri.parse(restaurant);

        titol.setText("Restaurant ");
        any.setText("2023");
        descripcio.setText("EL nou restaurant renovat");
        //uri video exemple
        videoView.setVideoURI(uriRestaruant);
        videoView.start();
    }

    /**
     * Metode que utliza la foto de tenda
     * @param vista View
     */
    public void onTiendaClick(View vista)
    {
        String mercadona = "android.resource://" + getPackageName() + "/" + R.raw.mercadona;
        Uri uriMercadona = Uri.parse(mercadona);

        titol.setText("Mercadona Song!");
        any.setText("2023");
        descripcio.setText("MERCADOONA MERCADOONA");
        videoView.setVideoURI(uriMercadona);
        videoView.start();
    }

    /**
     * Clcik viatgar
     * @param vista vista
     */
    public void onViatjarClick(View vista)
    {
        String luisito = "android.resource://" + getPackageName() + "/" + R.raw.viatje;
        Uri uriViatge = Uri.parse(luisito);

        titol.setText("Explorando el interior de una cueva de hielo!");
        any.setText("2023");
        descripcio.setText("Una travesía por el glaciar más grande Islandia. Me sentí en otro planeta. ");
        videoView.setVideoURI(uriViatge);
        videoView.start();
    }
}