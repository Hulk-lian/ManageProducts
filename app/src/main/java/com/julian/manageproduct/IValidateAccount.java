package com.julian.manageproduct;

import android.content.Context;
import android.text.TextUtils;

public interface IValidateAccount {

    int OK=0;
    int PASSWORD_DIGIT=1;
    int PASSWORD_CASE = 2;
    int PASSWORD_LENGTH = 3;
    int DATA_EMPTY=4;

    interface View{
        void setMessageError(String error, int errcCode);
    }

    interface Presenter{

       // boolean validateCredentialsUser(String user);
        //boolean validateCredentialsPass(String pass);

     static int validateCredentialsUser(String user) {
            if(TextUtils.isEmpty(user)){
                return DATA_EMPTY;
            }
            return OK;
        }


        static int validateCredentialsPass(String pass) {

            String mensRes="";//message out
            int errCode;
            boolean result=false;

            if(TextUtils.isEmpty(pass))//if the password is Empty

                if (!(pass.length() <8)) //if the lenght of the password has 8 or less

                    if (pass.matches("(.*(?=.*[A-Z]).*)")) //if contains uppercase

                        if (pass.matches("((?=.*[0-9]).*)")) { //if contains digit all ok

                            errCode=OK;
                        }
                        else { //No tiene digitos
                            errCode=PASSWORD_DIGIT;
                        }
                    else { //No tiene mayuscula
                        errCode= PASSWORD_CASE;
                    }
                else { //No tiene Minimo 8
                    errCode = PASSWORD_LENGTH;
                }
            else{
                errCode = DATA_EMPTY;
            }
            return errCode;
        }

    }
}
