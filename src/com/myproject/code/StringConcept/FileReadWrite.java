package com.myproject.code.StringConcept;

import java.io.*;
import java.util.Scanner;

public class FileReadWrite {

    public static void main(String[] args) throws IOException {
        String filePath="C:\\Users\\DELL\\Music\\JavaWorkspace\\src\\com\\myproject\\code\\StringConcept\\sample";

        fileReadWrite();
        readFileByChar(filePath);
    }

    public static String fileReadWrite() {
        try {
            //65 A - 90 Z   97 a - 122 z space = 32
            //String filePath="C:\\Users\\DELL\\Documents\\Test.txt.txt";
            String filePath="C:\\Users\\DELL\\Music\\JavaWorkspace\\src\\com\\myproject\\code\\StringConcept\\sample";
            File file = new File(filePath);
            Scanner sc= new Scanner(file);
            readFileByChar(filePath);
            StringBuilder sb=new StringBuilder();
            while(sc.hasNext()){
                sb.append(sc.next()).append(".. ");
            }
            System.out.println(sb);
            FileWriter fw= new FileWriter(file);
            fw.write("hey dude");
            fw.close();
            sc.close();
            printAscii();
            return sb.toString();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "";
    }
    public static String getFileContentByFilePath(String filePath) throws NullPointerException, FileNotFoundException {
            StringBuilder builder=new StringBuilder();
             File file=new File(filePath);
        Scanner sc = new Scanner(file);

        while(sc.hasNext()){
                 builder.append(sc.nextLine()).append(" ");
             }
        return builder.toString().trim();
    }



    public static String readFileByChar(String filePath) throws IOException {
        StringBuilder builder=new StringBuilder();
        FileReader fr = new FileReader(filePath);
        // Declaring loop variable
        int i;
        // Holds true till there is nothing to read
        while ((i = fr.read()) != -1) {
            if ((i > 64 && i < 90) || (i > 96 && i < 122) || i == 32)
                builder.append((char) i);
        }
        return builder.toString();
    }




    private static void printAscii(){
        for(int i=0;i<300;i++){
          char c= (char) i;
          if(c==' '){
              System.out.println("space "+i);
          }
          System.out.println(c+" "+i);
        }
    }

}
