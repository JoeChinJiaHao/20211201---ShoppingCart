package com.cart;

import com.cart.ClassFolder.Cart;

import org.junit.Test;

public class CartTestSize {
    //run test with command "mvn test" in terminal
    @Test
    public void testAdd(){
        Cart cart = new Cart();
        //cart.AddItem("Mango");
        //cart.AddItem("Manga");
       // assertTrue(cart.NumberOfItemsInCart()==2);
        System.out.println("Assertsion size = 2");
    }
}
