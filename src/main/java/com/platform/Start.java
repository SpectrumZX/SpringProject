package com.platform;

import com.platform.security.JwtUtil;
import com.platform.security.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Start {

 public static void main(String[] args) {

     User u = new User();
     u.setId(1L);
     u.setRole("ROLE_USER");
     u.setUsername("dima");
     JwtUtil util = new JwtUtil();


     DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
     Date date = new Date();
     System.out.println("Current date: "+dateFormat.format(date));

     System.out.println("TOKEN: "+util.generateToken(u));
 }


    }
