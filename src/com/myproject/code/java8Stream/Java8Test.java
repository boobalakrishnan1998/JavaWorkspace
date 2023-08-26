package com.myproject.code.java8Stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;

public class Java8Test {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 4, 10, 12, 87, 33, 75);

        int sum =numbers.stream().mapToInt(Integer::intValue).sum();
         System.out.println(sum);

         Random random=new Random();
         random.ints().limit(10).forEach(System.out::println);

        List<Integer> number= Arrays.asList(3, 2, 2, 3, 7, 3, 5);

       IntSummaryStatistics su= number.stream().mapToInt(Integer::intValue).summaryStatistics();

       
    }

}
