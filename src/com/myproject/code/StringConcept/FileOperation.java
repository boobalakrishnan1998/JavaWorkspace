package com.myproject.code.StringConcept;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileOperation {

    public static void main(String[] args) throws IOException {

        String filePath="C:\\Users\\DELL\\Documents\\Test.txt.txt";
        //fileReadByBufferedReader(filePath);//BufferedReader class for Reading text file
        //fileReadByFileReader(filePath);//FileReader class for Reading text file
        fileReadByScanner(filePath);//Scanner class for reading text file
        fileReadByAsString(filePath);//Read a text file as String
        print(filePath);
    }
    public static void fileReadByScanner(String filePath) throws IOException {
        //With using loops
        File file=new File(filePath);
        Scanner sc=new Scanner(file);
        StringBuilder resultStringBuilder = new StringBuilder();
        while(sc.hasNextLine()){
            resultStringBuilder.append(sc.nextLine());
            resultStringBuilder.append(System.getProperty("line.separator"));
        }
        //Without using loops
        Scanner sc1=new Scanner(file);
        sc1.useDelimiter("\\Z");
        System.out.println(sc1.next());
    }
    private static void fileReadByAsString(String filePath) throws IOException {
        String data= new String(Files.readAllBytes(Paths.get(filePath)));
        System.out.println(data);
    }

    public static void fileReadByBufferedReader(String filePath) throws IOException {
        // File path is passed as parameter
        File file = new File(filePath);
        // Creating an object of BufferedReader class
        BufferedReader br
                = new BufferedReader(new FileReader(file));
        String st;
        StringBuilder resultStringBuilder = new StringBuilder();
        // Condition holds true till
        // there is character in a string
        while ((st = br.readLine()) != null) {
            resultStringBuilder.append(st).append("\n");
            System.out.println(st);
        }
        System.out.println(resultStringBuilder);
    }

    public static void fileReadByFileReader(String filePath) throws IOException {
        // Passing the path to the file as a parameter
        FileReader fr = new FileReader(filePath);
        // Declaring loop variable
        int i;
        // Holds true till there is nothing to read
        while ((i = fr.read()) != -1)
            // Print all the content of a file
            System.out.print((char)i);

    }
    public static void print(String filePath) {
        File myObj = new File(filePath);
        if (myObj.exists()) {
            System.out.println("File name: " + myObj.getName());
            System.out.println("Absolute path: " + myObj.getAbsolutePath());
            System.out.println("Writeable: " + myObj.canWrite());
            System.out.println("Readable " + myObj.canRead());
            System.out.println("File size in bytes " + myObj.length());
        } else {
            System.out.println("The file does not exist.");
        }
    }
}
