package com.julian.manageproduct.login;

import android.content.Context;

import com.julian.manageproduct.R;

/**
 * Created by Hulk-lián on 22/10/2016.
 */

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

                if (pass.length()<8) //if the lenght of the password has 8 or less

                    if (pass.matches( patronpassMayus)) //if contains uppercase

                        if (pass.matches(patronpassNum)) { //if contains digit all ok

                            mensRes = ((Context)msgView).getResources().getString(R.string.loginOk); //all ok
                        }
                        else { //No tiene digitos
                            mensRes = ((Context) msgView).getResources().getString(R.string.passDigit);
                            
                            mensRes = R.id.et_passwd;
                        }
                    else { //No tiene mayuscula
                        mensRes = ((Context) msgView).getResources().getString(R.string.passCase);
                        idOut = R.id.et_passwd;
                    }
                else { //No tiene Minimo 8
                    mensRes = ((Context) msgView).getResources().getString(R.string.passMinLength);
                    idOut = R.id.et_passwd;
                }
            else{
                mensRes = ((Context)msgView).getResources().getString(R.string.data_empty);
                idOut = R.id.et_passwd;
            }
        else {
            mensRes = ((Context) msgView).getResources().getString(R.string.data_empty);
            idOut = R.id.et_user;
        }
    }
}
