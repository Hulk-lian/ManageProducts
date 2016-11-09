package com.julian.manageproduct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.concurrent.locks.Condition;

public class RegisterUser extends AppCompatActivity {

    EditText edtUser,edtPass,edtEmail,edtEmpName;
    Spinner spProv,spLoca;
    RadioGroup rdg;
    RadioButton rdbUser,rdbEmpr;
    Button btnok;
    CheckBox chbCondition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        edtUser=(EditText)findViewById(R.id.edtNombre);
        edtEmail=(EditText)findViewById(R.id.edtEmail);
        edtEmpName=(EditText)findViewById(R.id.edEmprName);
        edtPass=(EditText)findViewById(R.id.edtPassword);

        chbCondition=(CheckBox)findViewById(R.id.chbCondition);
        btnok=(Button)findViewById(R.id.RegisrobtnOK);

        spLoca=(Spinner)findViewById(R.id.spLocalidad);
        spProv=(Spinner)findViewById(R.id.spProvin);

        rdg=(RadioGroup)findViewById(R.id.rdgType);

        rdbEmpr=(RadioButton)findViewById(R.id.rdbEmpresa);
        rdbUser=(RadioButton)findViewById(R.id.rdbParticular);

        edtEmpName.setVisibility(View.GONE);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //add the user
                finish();
            }
        });
    }

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

}
