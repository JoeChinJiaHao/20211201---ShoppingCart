package com.cart.UseShoppingCart;

    import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cart.InputChecker;
    import com.cart.ClassFolder.Cart;
import com.cart.WriteHere.ShoppingCartDB;
public class UseCartWithDB {
    
    
    public static void main(String[] args) throws IOException {
        //Database direction and set the working directory
        String[] DBLoc = args;
        ShoppingCartDB wc = new ShoppingCartDB();
        List<String> loadStringList = new ArrayList<String>();
        //System.out.println(DBLoc.length);
        if(DBLoc.length == 0 && null != DBLoc){//make default if no entry
            wc.MakeDefaultDir();
        }else{//make directory if entered directory
            wc.MakeSpecificDir(DBLoc[0]);
        }
        InputChecker In = new InputChecker();
        Cart cart = new Cart();
        In.start();
        cart.start();
        System.out.println("Welcome to your shopping cart!");
        Console cons = System.console();
        String reply = "";
        String input = cons.readLine(">");
        Boolean logInPrior = false;
        String lastUser = "";
        List<String> userListTemp = new ArrayList<String>();

        while (!"exit".equals(input)){
            reply="";
            reply=In.Command(input);
            //list function basic
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
            }else if(reply.equals("login")){//login method
                //need to return second part of command which is name
                logInPrior=true;
                loadStringList = new ArrayList<String>();
                loadStringList = wc.PickDBFileInByte(In.CheckH());
                //delete existing cart item and load new list
                cart.ClearCart();
                for(String s:loadStringList){
                    //check if in cart
                    if(cart.InCart(s)){
                        //System.out.printf("You have %s in your cart \n",s);
                    }else{
                        //System.out.printf("%s added to cart \n", s);
                        cart.AddItem(s);
                    }
                }
                if(cart.CartSize()==0){
                    System.out.printf("%s, your cart is empty.\n",In.CheckH());
                }else if(cart.CartSize()>0){
                    System.out.printf("%s, your cart contains the following items\n",In.CheckH());
                    System.out.println(cart.UseList());
                }
                lastUser=In.CheckH();
            }else if(reply.equals("save")){//save method
                if(logInPrior==false){
                    System.out.println("Please login first.");

                }else{
                    wc.PickDBFileOut(lastUser, cart.GetCartList());
                }
            }else if(reply.equals("users")){//get userlist
                userListTemp= wc.GetUserList();
                Integer counter = 0;
                for(String s:userListTemp){
                    counter+=1;
                    System.out.println(counter.toString() + ". "+s);
                }
            }else{//when exit is entered
                System.out.printf("%s function not available \n",reply);
            }
            input = cons.readLine(">");
        }
        
        System.out.println("Thanks for shopping with us.");


        }





    }

