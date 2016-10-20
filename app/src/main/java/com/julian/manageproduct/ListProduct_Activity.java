package com.julian.manageproduct;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.julian.manageproduct.model.Product;

//internamente tiene un tipo definido que es lista
//nuestra interfaz se añadira un elemento llamado list view

public class ListProduct_Activity extends ListActivity {

    //si hay un fallo o no se agrega se queda en  si la agregacion va correctamente toma valor de 1
    private final static int resultadoAdd=0;

    //region explicacion

    //si no heredase de ListActivity habria que crear un objeto de ListView lvpProduct
    //y en  el on create hacer el findViewBy id

    //para que haga la vinculacion del xml con la lista (par aque haga el inflate) ha de
    //establecerle un id que existe en android con el @android:

    //endregion

    //variables
   private Button btnAdd;

   private ArrayAdapter<Product> adapter;//creacion de un array adapter para el caso 1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        btnAdd=(Button)findViewById(R.id.btnAdd);

        //CASO 1: Adapter no personalizado      toma el adapter no personalizado de android
        adapter= new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1,((Product_Aplication) getApplication()).getProducts());
        getListView().setAdapter(adapter);


        //CASO 2: Adapter personalizado


    }


    public void clickAdd(View view) {

        Intent i = new Intent(this, AddProduct_Activity.class);
        // Iniciamos la segunda actividad, y le indicamos que la iniciamos
        // para rellenar el nombre:
        startActivity(i);
    }
}
