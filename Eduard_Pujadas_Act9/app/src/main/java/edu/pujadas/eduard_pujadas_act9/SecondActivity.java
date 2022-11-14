package edu.pujadas.eduard_pujadas_act9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity
{
    private TextView marca,model,quant,ruta;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setTitle("Inventari Aula");

        //text views que agafo
        marca = findViewById(R.id.marca);
        model = findViewById(R.id.model);
        quant = findViewById(R.id.quant);
        ruta = findViewById(R.id.ruta);

        String infoMarca = getIntent().getStringExtra("infoMarca");

        marca.setText(infoMarca);
    }
}