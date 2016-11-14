package com.julian.manageproduct;

import android.util.Patterns;



public interface IValidateUser extends IValidateAccount {



    interface  Presenter {


        static int validateEmail(String email) {
            if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                return Error.EMAIL_INVALID;
            } else {
                return Error.OK;
            }
        }
    }
}
