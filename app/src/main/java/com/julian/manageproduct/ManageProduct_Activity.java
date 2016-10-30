package com.julian.manageproduct;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.julian.manageproduct.model.Product;

public class ManageProduct_Activity extends AppCompatActivity {

    //array adpter for the spinner
   // ArrayAdapter<CharSequence> arrayAdapter=ArrayAdapter.createFromResource(this,R.array.listUnit,android.R.layout.simple_spinner_item);

    Intent resultado;
    Bundle data;
    // private Button btnSave;
    private Spinner spOptions;
    private EditText edtName,edtDescription,edtDosage,edtBrand,edtPrice,edtStock;
    private String imgUrl;
    private Button btnOkAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_product_);

        // metodo para enlazar las variables con los componentes que tenemos en el XML
        inicialize();
    }

    private void inicialize() {

        spOptions=(Spinner)findViewById(R.id.spnUnitDosage);
       // btnSave=(Button)findViewById(R.id.btnSave);
        edtName=(EditText)findViewById(R.id.edtName);
        edtDescription=(EditText)findViewById(R.id.edtDescrip);
        edtDosage=(EditText)findViewById(R.id.edtDosage);
        edtBrand=(EditText)findViewById(R.id.edtBrand);
        edtPrice=(EditText)findViewById(R.id.edtPrice);
        edtStock=(EditText)findViewById(R.id.edtStock);
        btnOkAdd=(Button)findViewById(R.id.btnOk);

        //click en el boton
        btnOkAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(comprobacionDeDatos()){

                    crearProducto();
                    resultado= getIntent();
                    resultado.putExtra("data",data);
                    setResult(RESULT_OK,resultado);
                    finish();
                }
                else{
                    //avisar que hay campos sin datos.
                }

            }
        });

        //*----------------------------------*//
        // arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         //spOptions.setAdapter(arrayAdapter);
    }

    private void crearProducto() {
        data= new Bundle();
        data.putString("Name",edtName.getText().toString());
        data.putString("Description",edtDescription.getText().toString());
        data.putString("Brand",edtBrand.getText().toString());
        data.putString("Dosage",edtDosage.getText().toString());
        data.putDouble("Price",Double.parseDouble(edtPrice.getText().toString()));
        data.putInt("Img",R.drawable.drug);
        data.putInt("Stock",Integer.parseInt(edtStock.getText().toString()));

    }

    //cargar las diferentes opciones cuando se crea la activity
    @Override
    protected void onStart() {
        super.onStart();

    }

    private boolean comprobacionDeDatos(){
        boolean resultado=true;

        //recorrer los controles para evitar que no esten vacios


        return resultado;
    }

    public void clickImg(View view) {
        /*Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("file/*");
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivityForResult(intent,1);
        else
*/
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {

    }
}
