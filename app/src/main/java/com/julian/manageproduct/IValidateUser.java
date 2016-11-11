package com.julian.manageproduct;

import android.util.Patterns;

/**
 * Created by usuario on 11/11/16.
 */

public interface IValidateUser extends IValidateAccount {

    int EMAIL_INVALID=14;

    interface  Presenter
    {
        if(Patterns.EMAIL_ADRESS.matcher(email).matches()){
            return EMAIL_INVALID;
        }
        else
        {
            return OK;
        }
    }
}
