package com.cart;

import java.io.IOException;
import java.util.List;

import com.cart.ClassFolder.Cart;
import com.cart.WriteHere.ShoppingCartDB;

public class Temp {
    public static void main(String[] args) throws IOException {
        
    
        Cart cart = new Cart();
        ShoppingCartDB wc = new ShoppingCartDB();
        String DBLoc = "DB";
        if(DBLoc.length() == 0 && null != DBLoc){//make default if no entry
            wc.MakeDefaultDir();
        }else{//make directory if entered directory
            wc.MakeSpecificDir(DBLoc);
        }
        
        //wc.MakeDefaultDir();
        List<String> list = wc.PickDBFileInByte("fred");
        
        wc.PickDBFileOut("jack", list);
        list=wc.PickDBFileIn("jack");
        for(String s:list){System.out.println(s);}
        System.out.println(list.size());
    }   
}
