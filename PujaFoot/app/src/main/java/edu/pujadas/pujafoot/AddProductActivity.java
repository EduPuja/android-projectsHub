package edu.pujadas.pujafoot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import edu.pujadas.pujafoot.Objects.Product;

public class AddProductActivity extends AppCompatActivity
{

    //todo fer ho amb combobox

    EditText idProduct;
    EditText nameProduct;
    Spinner quantityProduct;
    Button  saveButon;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        setTitle("Add Product");
        idProduct = findViewById(R.id.idProduct);
        nameProduct = findViewById(R.id.nameProduct);
        quantityProduct = findViewById(R.id.quantitatProduct);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.quantitat_productes, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quantityProduct.setAdapter(adapter);
        saveButon = findViewById(R.id.saveBtn);



    }

    public void onSaveButon(View v)
    {

        if(idProduct.getText().toString().isEmpty() || nameProduct.getText().toString().isEmpty() ||quantityProduct.getSelectedItem().toString().isEmpty())
        {
            idProduct.setError("Camp vuit");
            nameProduct.setError("Camp vuit");



        }
        else
        { saveButon.setEnabled(true);
            int id = Integer.parseInt(idProduct.getText().toString());
            String name = nameProduct.getText().toString();
            int quantity =Integer.parseInt( quantityProduct.getSelectedItem().toString());


            Product product = new Product(id, name, quantity);
            UserActivity.listProducte.add(product);

            Intent  intent = new Intent(this,UserActivity.class);
            startActivity(intent);

        }





    }
}