package com.julian.manageproduct;

import android.content.Context;

public class LoginPresenter implements IValidateUser.Presenter {

    private IValidateUser.msgView msgView;
    private String patronpassNum="((?=.*[0-9]).*)";//number
    private String patronpassMayus="(.*(?=.*[A-Z]).*)";//characters uppercase

    public LoginPresenter(IValidateUser.msgView view) {
        this.msgView=view;
    }

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

}
