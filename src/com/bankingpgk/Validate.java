package com.bankingpgk;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static final Pattern SerialRegex=Pattern.compile(
    "[0-9]{10}");
    public static final Pattern PasswordRegex=Pattern.compile(
            "(?=.*[a-z])(?=.*[A-Z])(?=.*[.,-_;]).{7,15}",Pattern.CASE_INSENSITIVE);
    public static String validateSerial(String serial){
        Matcher matcher=SerialRegex.matcher(serial);
        if (matcher.find()){
            return serial;

        }else {
            throw new RuntimeException("Serial Not Invalid");
        }
    }
    public static String validatePassword(String password){
        Matcher matcher=PasswordRegex.matcher(password);
        if (matcher.find()){
            return password;
        }else {
            throw new RuntimeException("Password Not Invalid");
        }
    }
}
