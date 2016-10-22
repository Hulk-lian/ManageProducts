package com.julian.manageproduct;

import android.content.Context;

import com.julian.manageproduct.ILogin;
import com.julian.manageproduct.R;

public class LoginPresenter implements ILogin.Presenter {

    private ILogin.msgView msgView;
    private String patronpassNum="((?=.*[0-9]).*)";//number
    private String patronpassMayus="(.*(?=.*[A-Z]).*)";//characters uppercase

    public LoginPresenter(ILogin.msgView view) {
        this.msgView=view;
    }

    @Override
    public void validateCredentials(String user, String pass) {
        String mensRes="";//message out
        int errCode=0;

        if(!user.isEmpty()) //if user is Empty

            if(!pass.isEmpty())//if the password is Empty

                if (!(pass.length() <8)) //if the lenght of the password has 8 or less

                    if (pass.matches( patronpassMayus)) //if contains uppercase

                        if (pass.matches(patronpassNum)) { //if contains digit all ok

                            mensRes = ((Context)msgView).getResources().getString(R.string.loginOk); //all ok
                            errCode=0;
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
        else {
            mensRes = ((Context) msgView).getResources().getString(R.string.dataEmpty);
           errCode = R.id.edtUser;
        }

        msgView.setMessageError(mensRes,errCode);
    }
}
