package com.julian.manageproduct;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity implements ILogin.msgView{

    private ILogin.Presenter mLoginP;
    private EditText mEdtPassw, mEdtUser;
    private TextInputLayout mTilPass, mTilUser;
    private Button mBtnLogin;
    private final String TAG ="manageProduct";

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

        Typeface font=Typeface.createFromAsset(getAssets(),"font_too_beautiful.ttf");//hay que poner el enlace del recurso de la fuente
        mBtnLogin.setTypeface(font);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginP.validateCredentials(mEdtUser.getText().toString(), mEdtPassw.getText().toString());
            }
        });
    }
        private void logeo(){
            Intent intent = new Intent(this, Product_Activity.class);
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
        switch (errcCode) {
            case R.id.edtUser: // User Incorrecto
                mTilUser.setError(error);
                break;
            case R.id.edtPass: // Pass Incorreta
                mTilPass.setError(error);
                break;
            case 0: //Login Correcto
                Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
                logeo();
                break;
        }
    }
}
