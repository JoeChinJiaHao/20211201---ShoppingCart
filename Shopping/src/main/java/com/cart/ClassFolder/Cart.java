package com.cart.ClassFolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart implements Startable {
    public Cart(){}
    private Map<String, Integer> map = new HashMap<String, Integer>();
    @Override
    public void start() {
        // TODO Auto-generated method stub
        System.out.println("Starting Cart...");
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub
        System.out.println("Stopping Cart...");
    }
    private List<String> list = new ArrayList<String>();
    
    public void AddItem(String s){
        if(!s.equals(null)){
        //System.out.println(s);
        map.put(s, 1);
        list.add(s);
        }
    }
    public boolean InCart(String s){
        return map.containsKey(s);
    }

    public String GetItem(Integer i){
        String reply = list.get(i-1);
        return reply;
    }
    public Integer CartSize(){
        return list.size();
    }
    public void DeleteItem(String s){
        list.remove(s);
        map.remove(s);
    }
    public String UseList(){
        Integer i = list.size();
        String reply = "";
        if(i==0){
            reply = "Your cart is empty.";
        }else{
            for(Integer j=1;j<=list.size();j++){
                if(j<list.size()){
                    reply+=(j.toString())+". "+list.get(j-1)+"\n";
                }else{
                    reply+=(j.toString())+". "+list.get(j-1);
                }
            }
        }
        return reply;

    }

    public void ClearCart(){
        //map = new HashMap<String, Integer>();
        //list = new ArrayList<String>();
        map.clear();
        list=new ArrayList<String>();
    }
    public List<String> GetCartList(){
        return list;
    }


    
}
