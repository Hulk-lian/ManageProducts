package com.julian.manageproduct;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.julian.manageproduct.adapter.ProductAdapterRecycler;

public class Product_Activity extends AppCompatActivity {

    private ProductAdapterRecycler adapterRecycler;
    private RecyclerView rcvProduct;
   private Button btnAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        btnAdd=(Button)findViewById(R.id.btnAdd);

        adapterRecycler= new ProductAdapterRecycler(this);
        rcvProduct=(RecyclerView)findViewById(R.id.rcvRecycler);
        rcvProduct.setLayoutManager(new LinearLayoutManager(this));
        rcvProduct.setHasFixedSize(true);
        rcvProduct.setAdapter(adapterRecycler);
    }


    public void clickAdd(View view) {

        Intent i = new Intent(this, AddProduct_Activity.class);

        startActivity(i);
    }
}