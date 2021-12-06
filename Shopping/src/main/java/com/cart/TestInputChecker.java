package com.cart;

public class TestInputChecker {
    public static void main(String[] args) {
        InputChecker In = new InputChecker();
        In.start();
        In.Command("Add Apple, water, dragon den");
        System.out.println(In.AddCount());
        String[] Temp = new String[9];
        Integer counter = 0;
        for (String s:In.AddCommand()){
            //System.out.println(counter);
            System.out.println(s);
            counter+=1;
        }
        

    }
}
