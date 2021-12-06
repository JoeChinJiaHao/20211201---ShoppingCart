package com.cart;

import java.io.Console;

import javax.lang.model.util.ElementScanner14;

public class TempTestParse {
    public static void main(String[] args) {
       // System.out.println(Integer.parseInt("0.5"));
    Console cons = System.console();
    String BigI = "";
    Integer j=1;
    while(!BigI.equals("exit")){
        System.out.println("Enter a test numeric");
        BigI=cons.readLine().toLowerCase();
        //System.out.println(BigI);
        if(BigI.equals("exit")){
            System.out.println("Thanks!");
        }else if(BigI.equals("")){
            System.out.println("Empty String");
        }else if(BigI.contains(".")) {
            //System.out.println("Checking...\n");
            System.out.println("Please enter an integer!");
        }else{
            j = Integer.valueOf(BigI);
            System.out.println(j);
        }


    }

    }
}
