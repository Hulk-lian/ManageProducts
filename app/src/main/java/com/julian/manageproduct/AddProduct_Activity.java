package com.julian.manageproduct;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddProduct_Activity extends AppCompatActivity {

    //array adpter for the spinner
    //ArrayAdapter<CharSequence> arrayAdapter=ArrayAdapter.createFromResource(this,R.array.listUnit,android.R.layout.simple_spinner_item);

    private Spinner spOptions;
    private Button btnSave;
    private EditText edtName,edtDescription,edtDosage,edtBrand,edtPrice,edtStock;
    private String imgUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product_);

        // metodo para enlazar las variables con los componentes que tenemos en el XML
        inicialize();
    }

    private void inicialize() {
        spOptions=(Spinner)findViewById(R.id.spnUnitDosage);
        btnSave=(Button)findViewById(R.id.btnSave);
        edtName=(EditText)findViewById(R.id.edtName);
        edtDescription=(EditText)findViewById(R.id.edtDescrip);
        edtDosage=(EditText)findViewById(R.id.edtDosage);
        edtBrand=(EditText)findViewById(R.id.edtBrand);
        edtPrice=(EditText)findViewById(R.id.edtPrice);
        edtStock=(EditText)findViewById(R.id.edtStock);


        //*----------------------------------*//
      //  arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      //  spOptions.setAdapter(arrayAdapter);
    }

    //cargar las diferentes opciones cuando se crea la activity
    @Override
    protected void onStart() {
        super.onStart();

    }


    public void clickImg(View view) {
        /*Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("file/*");
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivityForResult(intent,1);
        else

            Toast.makeText(this, "No hay aplicación para manejar ficheros", Toast.LENGTH_SHORT).show();*/
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {

    }

    public void clickbtn(View view) {
    }
}
