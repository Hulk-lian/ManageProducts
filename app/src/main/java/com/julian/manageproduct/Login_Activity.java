package com.julian.manageproduct;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity implements IValidateAccount.View{

    private IValidateAccount.Presenter mLoginP;
    private EditText mEdtPassw, mEdtUser;
    private TextInputLayout mTilPass, mTilUser;
    private Button mBtnLogin;
    private final String TAG ="manageProduct";
    private TextView medtReg;
    private ViewGroup layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        mLoginP = new LoginPresenter(this); //presentador se referencia a la vista porque tiene conexion directa con la vista.
        mEdtUser = (EditText) findViewById(R.id.edtUser);
        mEdtPassw = (EditText) findViewById(R.id.edtPass);
        mTilUser = (TextInputLayout) findViewById(R.id.tilUser);
        mTilPass = (TextInputLayout) findViewById(R.id.tilPassword);
        mBtnLogin = (Button) findViewById(R.id.btLogin);
        medtReg = (TextView)findViewById(R.id.txvForget);

        layout=(RelativeLayout)findViewById(R.id.activity_login_);


        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //correccion
                //fallo porque si esta pero no lo ve
                mLoginP.validateCredentialsUser(mEdtUser.getText().toString());
                mLoginP.validateCredentialsPass(mEdtPassw.getText().toString());
            }
        });
    }
        private void logeo(){
            Intent intent = new Intent(this, ListProduct_Activity.class);
            startActivity(intent);
            finish();

        }

        @Override
        public void onStop(){
            super.onStop();
            Log.d(TAG, "Activity_finalizada");
        }


    @Override
    public void setMessageError(String error, int errcCode) {
        //se tiene que recoger le recurso cuyo bnombre sea el que se pasa en el name Resource

        String messageErro=getResources().getString(getResources().getIdentifier(error,"string",getPackageName()));

        switch (errcCode) {
            case R.id.edtUser: // User Incorrecto
                //mTilUser.setError(error);
                Snackbar.make(layout,messageErro,Snackbar.LENGTH_LONG).show();
                break;
            case R.id.edtPass: // Pass Incorreta
                mTilPass.setError(error);
                break;
            case 0: //Login Correcto
                Snackbar.make(layout,messageErro,Snackbar.LENGTH_LONG).show();
                logeo();
                break;
        }
    }

    public void clickTXV(View view) {
        Intent i = new Intent(this,SignUp.class);
        startActivity(i);

    }
}
