package com.myproject.java8.DefaultAndStaticMethod;

public interface MoviePart {
     default void movieBreakTime(){
        System.out.println("Movie interval time 45 mins");
    }
}
