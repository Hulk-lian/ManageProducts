package com.julian.manageproduct.preferences;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.julian.manageproduct.IPreference;

public class AccountPreference implements IPreference{

    //public  static final String FILE="com.julian.manageproduct_preferences";//ha de ser el id del application + manage_product
    private static IPreference accountPreference;
    public static final String USER="user";
    public static final String PASS="password";
    public static final String EMAIL="email";
    private SharedPreferences sharedPreferences;

    private AccountPreference(Context context){
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(context);
    }

   //singleton
    public static IPreference getInstance(Context context){

        if(accountPreference==null){
            accountPreference= new AccountPreference(context);
        }
        return accountPreference;
    }

    public void putUser(String user){
        getEditor().putString(USER,user).apply();//apply es asincrono si se quiere sincrono se usa commit
    }

    public  void putPass(String password){
        getEditor().putString(PASS,password).apply();
    }

    public void putEmail (String email){
        getEditor().putString(EMAIL,email).apply();
    }

    private SharedPreferences.Editor getEditor(){
        return  sharedPreferences.edit();
    }

}
