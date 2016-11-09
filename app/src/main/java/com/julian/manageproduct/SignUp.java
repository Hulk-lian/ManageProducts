package com.julian.manageproduct;

import android.support.annotation.ArrayRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

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


    }

    private void loadSpiners(){

        //inicializar el spiner de provincia
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.provincias,android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spProv.setAdapter(adapter);

        spinerListener= new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (view.getId()){
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

    }

    private void loadFromProv(int pos){
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource();

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spLoca.setAdapter(adapter);
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
