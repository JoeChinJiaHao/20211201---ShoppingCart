package com.cart;

import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) {
        
        String i = "Hi, I, am, John, Water Bottle";

        Scanner scan = new Scanner(i);
        scan.useDelimiter(",");
        String[] Ans = new String[5];
        Integer counter =0;
        while(scan.hasNext()){
            Ans[counter]=scan.next().trim().toLowerCase();
            counter+=1;
            //System.out.println(scan.next().trim().toLowerCase());
        }
        for(int j=0;j<Ans.length;j++){
            System.out.println(Ans[j]);
        }
        scan.close();
        
    }
}
