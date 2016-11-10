package com.julian.manageproduct.preferences;


import android.content.Context;
import android.content.SharedPreferences;

import com.julian.manageproduct.IPreference;

public class AccountPreference implements IPreference{

    public  static final String FILE="com.julian.manageproduct_preferences";
    private static IPreference accountPreference;
    public static final String USER="user";
    public static final String PASS="password";
    private static Context contexto;

    private AccountPreference(){

    }

   //singleton
    public static IPreference getInstance(Context context){

        if(accountPreference==null){
            accountPreference= new AccountPreference();
           contexto=context;
        }
        return accountPreference;
    }

    public static void putUser(Context context,String user){
        getEditor(context).putString(USER,user).apply();//apply es asincrono si se quiere sincrono se usa commit
    }

    private static SharedPreferences.Editor getEditor(Context context){

        SharedPreferences sharedPreferences = ;
        return SharedPreferences;
    }

}
