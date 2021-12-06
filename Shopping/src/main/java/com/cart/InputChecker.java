package com.cart;

//import java.io.StringBufferInputStream;
import java.util.Scanner;

import com.cart.ClassFolder.Startable;

public class InputChecker implements Startable {
    public InputChecker(){};
    private String Holder = ""; //holder for the second half of the string
    public String CheckInput(String i){
        String reply ="Input not recognised! Try Again.";
        if(i.equals("list")){
            reply = "list";
        }else if(i.equals("add")){
            reply = "add";
        }else if(i.equals("delete")){
            reply = "delete";
        }
        return reply;
    }

    public String Command(String i){
        Scanner scan = new Scanner(i);
        String p = scan.next().toLowerCase();
        while (scan.hasNext()){
        Holder = scan.nextLine().trim();
        }
        scan.close();
        return p;
    }
    public String CheckH(){
        
        return Holder;
    }
    public Integer AddCount(){
        //Integer count = Holder.replaceAll("[^,]","").length()+1;
        return Holder.replaceAll("[^,]","").length()+1;
    }

    public String[] AddCommand(){

        //Integer count = Holder.replaceAll("[^,]","").length()+1;
        String[] reply = new String[this.AddCount()];
        Integer c = 0;
        Scanner scan = new Scanner(Holder);
        scan.useDelimiter(",");
        while(scan.hasNext()){
            reply[c]=scan.next().trim().toLowerCase();
            //System.out.println(reply[c]);
            c+=1;
        }
        
        scan.close();
        return reply;
    }
    @Override
    public void start() {
        // TODO Auto-generated method stub
        System.out.println("Starting InputChecker....");
    }
    @Override
    public void stop() {
        // TODO Auto-generated method stub
        System.out.println("Stopping InputChecker...");
    }

    //Obselete items.............................................
    //...........................................................
    //...........................................................
    public String OldWayListCommand(){
        //String Reply[] = H.split();
        Integer count = Holder.replaceAll("[^,]","").length();
        //String[] reply = new String[count];
        String reply = "";
        for(Integer i =0; i<count;i++){
            //scan here but not optimal
        }   


        return reply;
    }

}
