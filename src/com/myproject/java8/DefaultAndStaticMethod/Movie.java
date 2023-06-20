package com.myproject.java8.DefaultAndStaticMethod;

public interface Movie {

     void movieName();

     default void movieBreakTime(){
        System.out.println("Movie interval time 15 mins");
    }

    static void movieCertificate(){
        System.out.println("Movie certificate is Q\\A");
    }
}
