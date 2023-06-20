package com.myproject.java8.MethodReference;


import java.util.Arrays;
import java.util.List;

public class MethodInterface {
    public void myMethod(){
        System.out.println("Instance Method");
    }
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

       //get count of empty string
      //  Long count =  strings.stream().filter(string -> string.isEmpty()).count();
        Long count =  strings.stream().filter(String::isEmpty).count();
        System.out.println("Empty string count "+count);
        MethodInterface obj = new MethodInterface();
        // Method reference using the object of the class
        MyInterface ref = obj::myMethod;
        // Calling the method of functional interface
        ref.display();
    }
}