package com.demo.automation.loginassessment.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.demo.automation.loginassessment.Utils.MyLoginException;

public class CommonMethods {
 public static boolean isValidPassword(String password)
    {
  
        // The below regex will validate the password rules
  //1. Contain at least one number
  //2. Contain at least one uppercase & Contain at least one lowercase
  //3. Contain at least one special character
  //4. Contain least 10 characters
  
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + ".{10,}$";
        
        Pattern p = Pattern.compile(regex);
  
        // If the password is empty
        // return false
        if (password == null) {
            return false;
        }
  
        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(password);
  
        // Return if the password
        // matched the ReGex
        return m.matches();
    }
 
 public void assertInput(String message, boolean assertion) throws MyLoginException {
  if(!assertion) {
   throw new MyLoginException(message) ;
  }
 }
 
 public void verifyUsername(String userName) throws MyLoginException {
  String regexForEmailaddress ="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
  String regexForMobileNumber="/^(07)\\d {9}+$/";
  String regexForPhoneNumber="/^(0)\\d {10}+$/";
  
  if(userName==null) {
   throw new MyLoginException("Please enter an input") ;
   
  }
  else if (userName.matches(regexForEmailaddress)) {
   assertInput("Please provider a valid emailID", userName.matches(regexForEmailaddress));
   System.out.println("Entered right email address");
  }
  else if(userName.length()==9) {
   assertInput("Please provider a valid MobileNumber", userName.matches(regexForMobileNumber));
   System.out.println("Entered right mobile number");
  }
  else if(userName.length()==10) {
   assertInput("Please provider a valid PhoneNumber", userName.matches(regexForPhoneNumber));
   System.out.println("Entered right mobile number");
  }
  else {
   throw new MyLoginException("Please enter a valid input");
  }
 }
 
 public void verifyPassword(String pwd) throws MyLoginException{
  String regexForPwd = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + ".{10,}$";
  
  if(pwd==null) {
   throw new MyLoginException("Please enter an input") ;
  }
  else if(pwd.matches(regexForPwd)) {
   assertInput("Please provider a valid pwd", pwd.matches(regexForPwd));
   System.out.println("Entered valid password");
  }
 }
 
 }

