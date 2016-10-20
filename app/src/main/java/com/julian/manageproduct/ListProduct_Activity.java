package com.julian.manageproduct;

import android.app.ListActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.julian.manageproduct.model.Product;

//internamente tiene un tipo definido que es lista
//nuestra interfaz se añadira un elemento llamado list view

public class ListProduct_Activity extends ListActivity {

    //region explicacion

    //si no heredase de ListActivity habria que crear un objeto de ListView lvpProduct
    //y en  el on create hacer el findViewBy id

    //para que haga la vinculacion del xml con la lista (par aque haga el inflate) ha de
    //establecerle un id que existe en android con el @android:

    //endregion

   private ArrayAdapter<Product> adapter;//creacion de un array adapter para el caso 1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        //CASO 1: Adapter no personalizado      toma el adapter no personalizado de android
        adapter= new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1,((Product_Aplication) getApplication()).getProducts());
        getListView().setAdapter(adapter);


        //CASO 2: Adapter personalizado


    }


}
