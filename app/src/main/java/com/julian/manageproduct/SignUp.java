package com.julian.manageproduct;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.ArrayRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;

public class SignUp extends AppCompatActivity {


    EditText edtUser,edtPass,edtEmail,edtEmpName;
    Spinner spProv,spLoca;
    RadioGroup rdgType;
   // RadioButton rdbUser,rdbEmpr;
    Button btnok;
    CheckBox chbCondition;

    private AdapterView.OnItemSelectedListener spinerListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edtUser=(EditText)findViewById(R.id.edtNombre);
        edtEmail=(EditText)findViewById(R.id.edtEmail);
        edtEmpName=(EditText)findViewById(R.id.edEmprName);
        edtPass=(EditText)findViewById(R.id.edtPassword);

        chbCondition=(CheckBox)findViewById(R.id.chbCondition);
        btnok=(Button)findViewById(R.id.RegisrobtnOK);

        spLoca=(Spinner)findViewById(R.id.spLocalidad);
        spProv=(Spinner)findViewById(R.id.spProvin);


        rdgType=(RadioGroup)findViewById(R.id.rdgType);


        //rdbEmpr=(RadioButton)findViewById(R.id.rdbEmpresa);
        //rdbUser=(RadioButton)findViewById(R.id.rdbParticular);


        edtEmpName.setVisibility(View.GONE);

        rdgType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(radioGroup.getCheckedRadioButtonId()==R.id.rdbEmpresa){
                    edtEmpName.setVisibility(View.VISIBLE);
                }
                else
                {
                    edtEmpName.setVisibility(View.GONE);
                }
            }
        });

        loadSpiners();
    }


    //click del boton
    public void signUp(View view){
       switch (validate()){
           case 1:
               Toast.makeText(getApplicationContext(),"Email formato incorrecto",Toast.LENGTH_LONG).show();
               break;
           case 2:
               Toast.makeText(getApplicationContext(),"Nombre vacío",Toast.LENGTH_LONG).show();
               break;
           case 3:
               Toast.makeText(getApplicationContext(),"Pass vacio",Toast.LENGTH_LONG).show();
               break;
           case 0:
               Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_LONG).show();
               addtheUser();
               break;
       }

    }

    private void addtheUser(){

    }

    private void loadSpiners(){

        //inicializar el spiner de provincia
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.provincias,android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spProv.setAdapter(adapter);

        spinerListener= new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (adapterView.getId()){
                    case R.id.spProvin:
                        loadFromProv(i);
                        break;

                    case R.id.spLocalidad:

                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
        this.spProv.setOnItemSelectedListener(spinerListener);
        this.spLoca.setOnItemSelectedListener(spinerListener);

    }

    private void loadFromProv(int pos){

        TypedArray res=getResources().obtainTypedArray(R.array.array_provincia_a_localidades);

        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,res.getResourceId(pos,0),android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spLoca.setAdapter(adapter);

    }

    public int validate(){

        int res=0;
        if(!Patterns.EMAIL_ADDRESS.matcher(edtEmail.getText().toString()).matches()){
            res=1;
        }
        else if(edtUser.getText().toString().trim()==""){
            res=2;
        }
        else if(edtPass.getText().toString().trim()=="")
            res=3;

        return res;
    }


    //region alternativa al checkedchange

/*
    //otra alternativa es el onCheckedChangeListener
    public void radioClick(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.rdbEmpresa:
                if (checked)
                    edtEmpName.setVisibility(View.VISIBLE);
                break;
            case R.id.rdbParticular:
                if (checked)
                    edtEmpName.setVisibility(View.GONE);
                break;
        }
    }
   */
    //endregion



}
