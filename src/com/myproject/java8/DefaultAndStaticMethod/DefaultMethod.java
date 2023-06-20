package com.myproject.java8.DefaultAndStaticMethod;

public class DefaultMethod implements Movie,MoviePart {
    public static void main(String[] args) {
        DefaultMethod defaultMethod=new DefaultMethod();
        defaultMethod.movieName();
        defaultMethod.movieBreakTime();
    }
    @Override
    public void movieName() {
        System.out.println("spider Man");
    }
    @Override
    public void movieBreakTime(){
         MoviePart.super.movieBreakTime();
        // Movie.super.movieBreakTime();
        //System.out.println("Movie interval time 30 mins");
    }
}
