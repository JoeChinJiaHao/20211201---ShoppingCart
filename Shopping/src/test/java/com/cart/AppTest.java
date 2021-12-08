package com.cart;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import com.cart.ClassFolder.Cart;
import com.cart.WriteHere.ShoppingCartDB;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    /* @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    } */
    @Test
    public void testAdd(){
        Cart cart = new Cart();
        cart.AddItem("Mango");
        cart.AddItem("Manga");
        cart.AddItem("Mann");
        cart.DeleteItem("Mann");
        assertTrue("Cart size with add and delete test", cart.CartSize()==2);
    }
    @Test
    public void TestUser() throws IOException{
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
        System.out.println(list.size());
        assertTrue("Login test", list.size()==3);
    }
    @Test
    public void TestUserSave() throws IOException{
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
        //System.out.println(list.size());
        assertTrue("Login test", list.size()==4);
    }
    @Test
    public void TestUserlist() throws IOException{
        Cart cart = new Cart();
        ShoppingCartDB wc = new ShoppingCartDB();
        String DBLoc = "DB";
        if(DBLoc.length() == 0 && null != DBLoc){//make default if no entry
            wc.MakeDefaultDir();
        }else{//make directory if entered directory
            wc.MakeSpecificDir(DBLoc);
        }
        
        //wc.MakeDefaultDir();
        List<String> list = wc.GetUserList();
        
        //System.out.println(list.size());
        assertTrue("Login test", list.size()==2);
    }


}
