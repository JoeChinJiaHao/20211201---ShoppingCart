package com.cart.WriteHere;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MakeDir {
    public static void main(String[] args) throws IOException {
        
        Path curPath = Paths.get("");
        String s = curPath.toAbsolutePath().toString()+"/haha/";
        s=s.replace("\\", "/");
        //System.out.println(s);
        Path path = Paths.get(s);
        File file = path.toFile();

        if(!file.exists()){
            System.out.printf("%s does not exist",s);
            //make directory
            Files.createDirectories(path);
        }else if(file.isFile()){
            System.out.printf("%s exist",s);
        }else{//is a directory
            System.out.printf("%s is a directory",s);
            //check if directory exists


        }
        /* if(!file.exists()){
            if(file.isFile()){
                System.out.println("File exist");
            }else{
                System.out.println("Directory does not exist");
            }
        }else{
        for (File f: file.listFiles()){
            System.out.printf("Filename is %s\n", f.getName());
        }
        } */
    }
}
