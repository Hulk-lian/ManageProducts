package com.julian.manageproduct;

import android.content.Intent;
import android.text.TextUtils;

public interface IValidateAccount {


    interface View{
        void setMessageError(String error, int errcCode);
        void starActivity(Intent intent);
    }

    interface Presenter{

       // boolean validateCredentialsUser(String user);
        //boolean validateCredentialsPass(String pass);

     static int validateCredentialsUser(String user) {
            if(TextUtils.isEmpty(user)){
                return Error.DATA_EMPTY;
            }
            return Error.OK;
        }

     static int validateCredentialsPass(String pass) {

            int errCode;
            boolean result=false;

            if(TextUtils.isEmpty(pass))//if the password is Empty

                if (!(pass.length() <8)) //if the lenght of the password has 8 or less

                    if (pass.matches("(.*(?=.*[A-Z]).*)")) //if contains uppercase

                        if (pass.matches("((?=.*[0-9]).*)")) { //if contains digit all ok

                            errCode=Error.OK;
                        }
                        else { //No tiene digitos
                            errCode=Error.PASSWORD_DIGIT;
                        }
                    else { //No tiene mayuscula
                        errCode= Error.PASSWORD_CASE;
                    }
                else { //No tiene Minimo 8
                    errCode = Error.PASSWORD_LENGTH;
                }
            else{
                errCode = Error.DATA_EMPTY;
            }
            return errCode;
        }

    }
}
