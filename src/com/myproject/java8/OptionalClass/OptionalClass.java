package com.myproject.java8.OptionalClass;

import java.util.Optional;

public class OptionalClass {



    public static void main(String args[]) throws NoSuchFieldException {
           mapFilter();
         //isPresentCheck();
         //ifPresentCheck();
    }

    private static void isPresentCheck() {
       String name="Boobala Krishnan";
       Optional<String> optStr=Optional.ofNullable(name);
        //Optional<String>  optStr=Optional.of(name);
       //Optional<String>  optStr=Optional.empty();
        if(optStr.isPresent()){
            System.out.println("given String "+optStr.get()+" is not empty ");
        }
        Runnable runnable = System.out::println;
        runnable.run();
    }
    private static void ifPresentCheck() throws NoSuchFieldException {
        String name="Boobala Krishnan";
        Optional<String> optStr= Optional.of(Optional.ofNullable(name).orElse(getString()));
        //Optional<String> optStr= Optional.of(Optional.ofNullable(name).orElseGet(()->getString()));

        //Optional<String>  optStr=Optional.of(name);
        //Optional<String>  optStr=Optional.empty();
        optStr.ifPresent(str-> System.out.println("given string in str "+str));
        optStr.orElseThrow(NoSuchFieldException::new);
        System.out.println("given String "+optStr+" is not empty ");
    }
    public static String getString(){
        System.out.println("Inside getString BK");
        return "BK";
    }

    public static void mapFilter(){
        String name="Boobala Krishnan";
        Optional<String> optStr=Optional.ofNullable(name);
        Boolean validName=optStr.filter(nameStr->nameStr.length()>=5).isPresent();
        System.out.println(validName);
    }





}
