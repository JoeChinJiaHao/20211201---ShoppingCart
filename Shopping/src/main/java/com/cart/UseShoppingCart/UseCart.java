package com.cart.UseShoppingCart;

import java.io.Console;

import com.cart.InputChecker;
import com.cart.ClassFolder.Cart;

public class UseCart {
    public static void main(String[] args) {
        InputChecker In = new InputChecker();
        Cart cart = new Cart();
        
        In.start();
        cart.start();
        System.out.println("Welcome to your shopping cart!");
        Console cons = System.console();
        String reply = "";
        String input = cons.readLine(">");
        
        while (!"exit".equals(input)){
            
            reply="";
            reply=In.Command(input);
            

            if(reply.equals("list")){
                //code here
                System.out.println(cart.UseList());
            }else if(reply.equals("add")){
                //get string array of items to be added
                for(String s:In.AddCommand()){
                    //check if in cart
                    if(cart.InCart(s)){
                        System.out.printf("You have %s in your cart \n",s);
                    }else{
                        System.out.printf("%s added to cart \n", s);
                        cart.AddItem(s);
                    }
                }

            }else if(reply.equals("delete")){
                //delete item here
                if(cart.CartSize()==0){//cart is empty
                    System.out.println("Your cart is empty!");
                }else if(In.CheckH().contains(".")) {
                    System.out.println("Please enter an integer index.");
                }else if(Integer.valueOf(In.CheckH())>cart.CartSize()){
                    System.out.println("Incorrect item index");
                }else if(Integer.valueOf(In.CheckH())<=0){
                    System.out.println("Incorrect item index");
                }else {//number is 
                    System.out.println(cart.GetItem(Integer.valueOf(In.CheckH()))+ " removed from cart");
                    cart.DeleteItem(cart.GetItem(Integer.valueOf(In.CheckH())));
                    
                }
            }else{
                System.out.printf("%s function not available \n",reply);
            }
            input = cons.readLine(">");
        }
        System.out.println("Thanks for shopping with us.");
    }
}
