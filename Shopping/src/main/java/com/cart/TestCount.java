package com.cart;

public class TestCount {
    public static void main(String[] args) {
        String i="Hi, I, am, Jack.";
        int count = i.replaceAll("[^,]","").length();
        System.out.println(count);
        System.out.println(i);
        
    }
}
