package com.julian.manageproduct;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.julian.manageproduct.adapter.ProductAdapterRecycler;

//internamente tiene un tipo definido que es lista
//nuestra interfaz se añadira un elemento llamado list view

public class Product_Activity extends AppCompatActivity {

    private ProductAdapterRecycler adapterRecycler;
    private RecyclerView rcvProduct;
    //variables
   private Button btnAdd;

    //private ArrayAdapter<Product> adapter;//creacion de un array adapter para el caso 1
   // private ProductAdapterA adapter; //creacion de un adapter del tipo product (custom adapter)
    //private ProductAdapterB adapter;
    //private ProductAdapterC adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        btnAdd=(Button)findViewById(R.id.btnAdd);

        adapterRecycler= new ProductAdapterRecycler(this);
        rcvProduct=(RecyclerView)findViewById(R.id.rcvRecycler);
        rcvProduct.setAdapter(adapterRecycler);
    }


    public void clickAdd(View view) {

        Intent i = new Intent(this, AddProduct_Activity.class);

        startActivity(i);
    }
}
