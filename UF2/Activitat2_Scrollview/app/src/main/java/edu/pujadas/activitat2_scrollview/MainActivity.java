package edu.pujadas.activitat2_scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {


    TextView title,year,description;
    HorizontalScrollView scrollView;

    ImageView car_1, car_2, car_3, car_4, car_5, car_6;

    VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //find by id
        title = findViewById(R.id.title);
        year = findViewById(R.id.year);
        description = findViewById(R.id.descrip);
        video = findViewById(R.id.video);
        video.setVisibility(View.INVISIBLE); // hide the video for better front-end

        // adding the blank text
        title.setText("");
        year.setText("");
        description.setText("");

        scrollView = findViewById(R.id.scroll_view);
        // find the images by the id
        car_1 = findViewById(R.id.car1);
        car_2 = findViewById(R.id.car2);
        car_3 = findViewById(R.id.car3);
        car_4 = findViewById(R.id.car4);
        car_5 = findViewById(R.id.car5);
        car_6 = findViewById(R.id.car6);


        car_1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), "hola", Toast.LENGTH_LONG).show();
                setText("Volwavgent","1999","Mejor cotche de los años 90");
                video.setVisibility(View.VISIBLE);
                video.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.ibai);
                video.start();

            }

        });

        car_2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), "hola", Toast.LENGTH_LONG).show();
                setText("Toyota Supra","2000","Clascio de las peliculas");
                video.setVisibility(View.VISIBLE);
                video.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.ibai);
                video.start();
            }


        });
        car_3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), "hola", Toast.LENGTH_LONG).show();
                setText("Tesla","2020","Una lavadora, no sirve de mucho ");
                video.setVisibility(View.VISIBLE);
                video.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.ibai);
                video.start();
            }
        });
        car_4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), "hola", Toast.LENGTH_LONG).show();
                setText("Subauwu","1992","El mejor 1r coche de drift del mundo");
                video.setVisibility(View.VISIBLE);
                video.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.ibai);
                video.start();
            }

        });
        car_5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                setText("Mitshubishi Evo","2000","El segundo mejor coche de drift del la historia");
                video.setVisibility(View.VISIBLE);
                video.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.ibai);
                video.start();
            }
        });
        car_6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), "hola", Toast.LENGTH_LONG).show();
                setText("Range Rover","2008", "Coche de ricos ");
                video.setVisibility(View.VISIBLE);
                video.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.ibai);
                video.start();
            }
        });

    }

    private void setText(String titol,String any,String descrip) {
        title.setText("Titol: "+titol);
        year.setText("Any : "+any);
        description.setText("Descrip :"+descrip);


    }
}