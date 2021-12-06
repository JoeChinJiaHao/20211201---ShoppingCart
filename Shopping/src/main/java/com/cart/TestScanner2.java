package com.cart;

import java.util.Scanner;

public class TestScanner2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner("Hello");
        String p = scan.next().toLowerCase();
        String Holder="";
        while(scan.hasNext()){
        Holder = scan.nextLine().trim();
        //System.out.println("hi");
        }
        System.out.println(p);
        System.out.println(Holder);
        scan.close();
    }
}
