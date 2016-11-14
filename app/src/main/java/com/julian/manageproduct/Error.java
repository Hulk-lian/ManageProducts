package com.julian.manageproduct;


public class Error {
    public static final int PASSWORD_DIGIT=1;
    public static final int PASSWORD_CASE = 2;
    public static final int PASSWORD_LENGTH = 3;
    public static final int DATA_EMPTY=4;
    public static final int OK=0;
    public static final int EMAIL_INVALID=5;

    public static int code;//error code
    public static String message;//message code

    static {

    }

}
