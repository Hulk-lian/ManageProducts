package com.julian.manageproduct;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.julian.manageproduct.adapter.ProductAdapterRecycler;
import com.julian.manageproduct.model.Product;
import com.julian.manageproduct.setting.AccountSettingActivity;
import com.julian.manageproduct.setting.GeneralSettingActivity;

public class Product_Activity extends AppCompatActivity {

    private ProductAdapterRecycler adapterRecycler;
    private RecyclerView rcvProduct;

    private static final int ADD_PRODUCT=0;
    private static final int EDIT_PRODUCT=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        adapterRecycler= new ProductAdapterRecycler(this);
        rcvProduct=(RecyclerView)findViewById(R.id.rcvRecycler);
        rcvProduct.setLayoutManager(new LinearLayoutManager(this));
        rcvProduct.setHasFixedSize(true);

        rcvProduct.setAdapter(adapterRecycler);
    }
    /*
    Metodo que infla em menu en la activity
    */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_product_activity,menu);
        return super.onCreateOptionsMenu(menu);
    }

/*
    devuelve true si se ha realizado una operacion y no se quiere que se propague a una clase que hay por arriba
    flase cuado no se ha consumido el evento.
 */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {

            case R.id.action_add_product:
                intent=new Intent(Product_Activity.this,ManageProduct_Activity.class);
                startActivityForResult(intent,ADD_PRODUCT);
                break;

            case R.id.action_action_order_alphabetical:
                //dao
                    adapterRecycler.getAlphSortedProducts();

                break;

            case R.id.action_setting_general:
                intent =new Intent(Product_Activity.this,GeneralSettingActivity.class);
                startActivity(intent);
                break;

            case R.id.action_setting_account:
                intent =new Intent(Product_Activity.this,AccountSettingActivity.class);
                startActivity(intent);
                break;
        }
        return  super.onOptionsItemSelected(item);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Bundle b;
        Product p;
        if(resultCode!=RESULT_CANCELED) {

            switch (requestCode) {

                case ADD_PRODUCT:

                    //añadir el producto

                    //recoger los datos
                    b=data.getExtras().getBundle("data");
                    //b= getIntent().getBundleExtra("data");
                    //get data product
                    p = new Product(b.getString("Name"),
                        b.getString("Description"),
                        b.getString("Brand"),
                        b.getString("Dosage"),
                        b.getDouble("Price",0.0),
                        b.getInt("Img",0),
                        b.getInt("Stock",0));

                    //add product
                   adapterRecycler.addProducto(p);

                    break;

                case EDIT_PRODUCT:


                    break;
            }
        }
        else
            Toast.makeText(this, "Resultado cancelado", Toast.LENGTH_LONG).show();
    }
}