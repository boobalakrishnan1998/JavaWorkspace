package com.myproject.java8.DefaultAndStaticMethod;

public class StaticMethod implements Movie {
    public static void main(String[] args) {
        StaticMethod staticMethod=new StaticMethod();
        Movie.movieCertificate();
        staticMethod.movieBreakTime();
        staticMethod.movieName();
    }
    @Override
    public void movieName() {
        System.out.println("Movie Name : Jocker");
    }
}
