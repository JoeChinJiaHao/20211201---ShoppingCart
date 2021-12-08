package com.cart.WriteHere;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.print.attribute.SupportedValuesAttribute;
public class ShoppingCartDB {
    

    public ShoppingCartDB(){}
    private Path UD;
    
    public String DefaultDBDirStr(){
        //get working directory
        Path curPath = Paths.get("");
        String s = curPath.toAbsolutePath().toString()+"/DB/";
        s=s.replace("\\", "/");
        return s;
    }
    public Path WorkingDirPath(){
        Path curPath = Paths.get("");
        String s = curPath.toAbsolutePath().toString()+"/";
        s=s.replace("\\", "/");
        Path path = Paths.get(s);
        return path;
    }
    public Path DefaultDBDirPath(){
        Path curPath = Paths.get("");
        String s = curPath.toAbsolutePath().toString()+"/DB/";
        s=s.replace("\\", "/");
        Path path = Paths.get(s);
        return path;
        
    }
    public void MakeDefaultDir() throws IOException{
        //System.out.println(this.DefaultDBDirStr());
        Files.createDirectories(this.DefaultDBDirPath());
        UD=this.DefaultDBDirPath();
        
    }
    public void MakeSpecificDir(String i) throws IOException{
        String j = this.WorkingDirPath().toString()+"\\"+i;
        j=j.replace("\\", "/");
        
        Path path = Paths.get(j);
        Files.createDirectories(path);
        UD=path;
    }
    public Path UsedDirectory(){
        return UD;
    }
    public List<String> PickDBFileIn(String s) throws IOException{
        //used for login to load a shopping cart
        List<String> reply = new ArrayList<String>();
        //check if DB is there if not make it
        //then return the content into reply
        String i = this.UsedDirectory().toString()+"/"+s.toLowerCase()+".db";
        i=i.replace("\\", "/");
        //System.out.println(i);
        Path p = Paths.get(i);
        File f = p.toFile();
        if(!f.exists()){
            //make the file here
            Files.createFile(p);
            //no need to read list
        }else{
            
            //file exist here thus add content
            InputStream is = new FileInputStream(f);
            int size =0;
            String tt ="";
            byte[] buffer = new byte[1024]; 
            while (-1 !=(size = is.read(buffer))){
                tt=new String(buffer,StandardCharsets.UTF_8);
                Scanner scan = new Scanner(tt);
                
                scan.useDelimiter("\n");
                while(scan.hasNext()){
                    tt=scan.next().toLowerCase();
                    //System.out.println("haha");
                    //System.out.println(tt);
                    if(!tt.equals("")){
                    reply.add(tt);
                    }
                }
                
               scan.close();

            }
            is.close();

        }

        /* for(String ss:reply){
            System.out.println(ss);
        } */
        return reply;
    }
    public void PickDBFileOut(String s,List<String> list1) throws IOException{
        //save a shopping cart
        //check if there is file else sysout fail
        String i = this.UsedDirectory().toString()+"/"+s+".db";
        i=i.replace("\\", "/");
        //System.out.println(i);
        Path p = Paths.get(i);
        File f = p.toFile();
        if(!f.exists()){
            //Declare fail
            System.out.println("No such user, try again!");
            //no need to read list
        }else{
            //clear all files first
            PrintWriter writer = new PrintWriter(f);
            //write into the text
            writer.print("");
            writer.close();
            /* OutputStream os = new FileOutputStream(f);
            for(String sick:list1){
                os.write(sick.getBytes(StandardCharsets.UTF_8),0, sick.length());
            }
            os.flush();
            os.close(); */
            //trying with filewriter
            FileWriter fw = new FileWriter(f, true);
            //true is set to append
            BufferedWriter bw = new BufferedWriter(fw);
            //buffered writer uses java instead of underlying O/S making the program more efficient 
            PrintWriter pw = new PrintWriter(bw);
            //printwriter grant access to println to print out string
            for(String sick:list1){
                pw.println(sick);
            }
            pw.close();
            bw.close();
            fw.close();
        }

    }
    public List<String> GetUserList(){
        //for getting user list
        
        List<String> uList = new ArrayList<String>();
        File filesInFolder = new File(this.UsedDirectory().toString());
        for(File f:filesInFolder.listFiles()){
            Scanner scan = new Scanner(f.getName()); 
            scan.useDelimiter(".db");
            String ss = scan.next().toLowerCase();
            //System.out.println(ss);
            uList.add(ss);
            scan.close();
        }
        return uList;
    }
    public List<String> PickDBFileInByte(String s) throws IOException{
        //used for login to load a shopping cart
        List<String> reply = new ArrayList<String>();
        //check if DB is there if not make it
        //then return the content into reply
        String i = this.UsedDirectory().toString()+"/"+s.toLowerCase()+".db";
        i=i.replace("\\", "/");
        //System.out.println(i);
        Path p = Paths.get(i);
        File f = p.toFile();
        if(!f.exists()){
            //make the file here
            Files.createFile(p);
            //no need to read list
        }else{
            //file exist here thus add content
            //try buffered reader
            BufferedReader in = new BufferedReader(new FileReader(f));
            String line;
            while((line=in.readLine())!=null){
                reply.add(line);
            }
            in.close();
            /*InputStream is = new FileInputStream(f);
            int size =0;
            String tt ="";
            byte[] buffer = new byte[1024]; 
            
             while (-1 !=(size = is.read(buffer))){

                String ssa = "haha";
                System.out.println(ssa.getBytes());
                tt=new String(buffer,StandardCharsets.UTF_8);
                Scanner scan = new Scanner(tt);
                
                scan.useDelimiter("\n");
                while(scan.hasNext()){
                    tt=scan.next().toLowerCase();
                    
                    if(!tt.equals("")){
                    reply.add(tt);
                    }
                }
                
               scan.close(); 

            }
            is.close();*/

        }
        return reply;
    }

}


