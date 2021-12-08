package com.cart.DatabaseRun;

import java.io.Console;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;

import com.cart.WriteHere.WriteControl;


public class DataB {
    public static void main(String[] args) throws IOException {
        String[] DBLoc = args;
        
        WriteControl wc = new WriteControl();
        //System.out.println(DBLoc.length);
        if(DBLoc.length == 0 && null != DBLoc){//make default if no entry
            wc.MakeDefaultDir();
        }else{//make directory if entered directory
            wc.MakeSpecificDir(DBLoc[0]);
        }

        //task includes login command, save command
        //login - check if database has dbfile else add. Then load the list with the data in db
        //save - save current cart into db under user, if user did not login firs tehn urge user to login
        //users - list all users in the db directory
        //System.out.println(wc.UsedDirectory().toString());

        Console cons = System.console();
        String input = cons.readLine(">").toLowerCase();
        List<String> tempList = new ArrayList<>();
        List<String> userList = new ArrayList<>();
        while(!input.equals("exit")){
            wc.GetUserList();
            //command input here
            tempList=wc.PickDBFileIn(input);
            for(String s:tempList){
                System.out.println(s);
            }
            //output to another db file
            wc.PickDBFileOut("Ted", tempList);
            input = cons.readLine(">");
        }

    }


}
