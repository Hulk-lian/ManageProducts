package com.julian.manageproduct;

import android.content.Context;
import android.content.Intent;

import com.julian.manageproduct.utils.ErrorMapUtils;

import java.util.Map;

import static com.julian.manageproduct.IValidateAccount.Presenter.validateCredentialsUser;
import static com.julian.manageproduct.IValidateAccount.Presenter.validateCredentialsPass;

public class LoginPresenter implements IValidateAccount.Presenter {

    private IValidateAccount.View view;
    private int validateUser;
    private int validatePass;
    private Context context;

    public LoginPresenter(IValidateUser.View view) {
        this.view=view;
        context=(Context)view;
    }


    public void validateCredentialsLogin(String user,String pass){
        validateUser=validateCredentialsUser(user);
        validatePass=validateCredentialsPass(pass);

        if((validateUser==Error.OK)) {

            if (validatePass==Error.OK) {
                Intent intent = new Intent((Context) view, ListProduct_Activity.class);
                view.starActivity(intent);
            }
            else {
                String nameResource= ErrorMapUtils.getErrorMap(context).get(String.valueOf(validateUser));
                view.setMessageError(nameResource,R.id.tilPassword);
            }
        } else {
            //obtiene el valor de dentro de error_map
            String nameResource= ErrorMapUtils.getErrorMap(context).get(String.valueOf(validateUser));
            view.setMessageError(nameResource,R.id.tilUser);
        }


    }
}

   /*
    @Override
    public boolean validateCredentialsUser(String user) {
        String mensRes="";//message out
        int errCode=0;

        if(!user.isEmpty()){
            mensRes = ((Context) msgView).getResources().getString(R.string.dataEmpty);
            errCode = R.id.edtUser;
            return  false;
        }

        msgView.setMessageError(mensRes,errCode);
        return  true;
    }

    @Override
    public boolean validateCredentialsPass(String pass) {
        String mensRes="";//message out
        int errCode;
        boolean result=false;

        if(!pass.isEmpty())//if the password is Empty

            if (!(pass.length() <8)) //if the lenght of the password has 8 or less

                if (pass.matches( patronpassMayus)) //if contains uppercase

                    if (pass.matches(patronpassNum)) { //if contains digit all ok

                        mensRes = ((Context)msgView).getResources().getString(R.string.loginOk); //all ok
                        errCode=0;
                         result= true;
                    }
                    else { //No tiene digitos
                        mensRes = ((Context) msgView).getResources().getString(R.string.passDigit);
                        errCode= R.id.edtPass;
                    }
                else { //No tiene mayuscula
                    mensRes = ((Context) msgView).getResources().getString(R.string.passCase);
                    errCode= R.id.edtPass;
                }
            else { //No tiene Minimo 8
                mensRes = ((Context) msgView).getResources().getString(R.string.passMinLength);
                errCode = R.id.edtPass;
            }
        else{
            mensRes = ((Context)msgView).getResources().getString(R.string.dataEmpty);
            errCode = R.id.edtPass;
        }

        msgView.setMessageError(mensRes,errCode);
        return result;
    }
    */

