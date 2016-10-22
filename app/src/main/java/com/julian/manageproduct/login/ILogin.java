package com.julian.manageproduct.login;

public interface ILogin {

    int PASSWORD_DIGIT=1;
    int PASSWORD_CASE = 2;
    int PASSWORD_LENGTH = 3;
    int DATA_EMPTY=4;

    interface msgView{
        public void setMessageError(String error);
    }
    interface Presenter{
        public void validateCredentials(String user,String pass);
    }
}
